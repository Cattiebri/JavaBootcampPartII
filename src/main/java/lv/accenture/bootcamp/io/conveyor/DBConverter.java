package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.db.DBUtil;
import lv.accenture.bootcamp.io.model.Course;
import lv.accenture.bootcamp.io.model.Lection;
import lv.accenture.bootcamp.io.model.Student;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("DBConverter")
public class DBConverter implements Converter {

    @Override
    public Course readFromFile(String path) throws Exception {
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        long courseId = Long.parseLong(new String(fileBytes));
        Connection connection = null;
        try {
            connection = DBUtil.acquireConnection();

            ResultSet courseResultSet = getCourseResultSet(courseId, connection);
            String courseTitle = courseResultSet.getString(2);
            String teacher = courseResultSet.getString(3);
            String dateFormat = courseResultSet.getString(4);

            ResultSet studentResultSet = getStudentResultSet(courseId, connection);

            String studentIdBuilder = "";
            List<Student> students = new ArrayList<>();
            while (studentResultSet.next()) {
                long studentId = studentResultSet.getLong(1);
                studentIdBuilder += (studentId);
                if(!studentResultSet.isLast()) {
                    studentIdBuilder += ",";
                }
                Student student = createStudentFromRS(studentResultSet, studentId);
                students.add(student);
            }
            studentResultSet.close();

            Map<Long, List<Lection>> studentLections = new HashMap<>();
            String lectionQuery = "select * from LECTION where COURSE_ID=" + courseId +
                    " AND STUDENT_ID IN (" + studentIdBuilder + ")";
            ResultSet lectionResultSet = connection.createStatement().executeQuery(lectionQuery);
            while(lectionResultSet.next()) {
                long lectionStudentId = lectionResultSet.getLong(3);
                Lection lection = createLectionFromRS(lectionResultSet);
                List<Lection> studentLectionList = studentLections.get(lectionStudentId);
                if(studentLectionList != null) {
                    studentLectionList.add(lection);
                } else {
                    studentLectionList = new ArrayList<>();
                    studentLectionList.add(lection);
                    studentLections.put(lectionStudentId, studentLectionList);
                }
            }
            lectionResultSet.close();

            for (Long studentId : studentLections.keySet()) {
                List<Lection> lections = studentLections.get(studentId);
                for (Student student : students) {
                    if(student.getId().equals(studentId)) {
                        student.setDailyReports(lections);
                        break;
                    }
                }
            }

            courseResultSet.close();

            return new Course(courseTitle, teacher, dateFormat, students);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private ResultSet getStudentResultSet(long courseId, Connection connection) throws SQLException {
        String studentQuery = "Select * from STUDENT where ID in (select STUDENT_ID from LECTION where COURSE_ID = ?)";
        PreparedStatement studentPreparedStatement = connection.prepareStatement(studentQuery);
        studentPreparedStatement.setLong(1, courseId);
        return studentPreparedStatement.executeQuery();
    }

    private ResultSet getCourseResultSet(long courseId, Connection connection) throws SQLException {
        String courseQuery = "Select * from COURSE where ID = ?";
        PreparedStatement coursePreparedStatement = connection.prepareStatement(courseQuery);
        coursePreparedStatement.setLong(1, courseId);
        ResultSet courseResultSet = coursePreparedStatement.executeQuery();
        courseResultSet.next();
        return courseResultSet;
    }

    private Student createStudentFromRS(ResultSet studentResultSet, long studentId) throws SQLException {
        String firstName = studentResultSet.getString(2);
        String lastName = studentResultSet.getString(3);
        Byte age = studentResultSet.getByte(4);
        String practiseCompany = studentResultSet.getString(5);

        Student student = new Student(firstName, lastName, age, practiseCompany);
        student.setId(studentId);
        return student;
    }

    private Lection createLectionFromRS(ResultSet lectionResultSet) throws SQLException {
        long lectionDate = lectionResultSet.getDate(4).getTime();
        boolean isPresent = lectionResultSet.getBoolean(5);
        Byte mark = lectionResultSet.getByte(6);
        if(lectionResultSet.wasNull()) {
            mark = null;
        }
        return new Lection(lectionDate, isPresent, mark);
    }

    @Override
    public void writeToFile(Course model, String path) throws Exception {
        cleanDatabase();

        Connection connection = null;
        try {
            connection = DBUtil.acquireConnection();

            Long courseId = insertCourseRecord(model, connection);
            for (Student student : model.getStudents()) {

                Long studentId = insertStudentRecord(connection, courseId, student);

                for (Lection lection : student.getDailyReports()) {
                    insertLectionRecord(connection, courseId, studentId, lection);
                }
            }

            Files.write(Paths.get(path), String.valueOf(courseId).getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    private Long insertStudentRecord(Connection connection, Long courseId, Student student) throws SQLException {
        Long studentId = null;
        String insertStudentSql = "insert into STUDENT(FIRST_NAME, LAST_NAME, AGE, PRACTISE_COMPANY) values (?,?,?,?)";
        PreparedStatement studentInsertStatement = connection.prepareStatement(
                insertStudentSql, Statement.RETURN_GENERATED_KEYS);
        studentInsertStatement.setString(1, student.getFirstName());
        studentInsertStatement.setString(2, student.getLastName());
        studentInsertStatement.setByte(3, student.getAge());
        studentInsertStatement.setString(4, student.getPractiseCompany());
        studentInsertStatement.executeUpdate();

        try (ResultSet generatedKeys = studentInsertStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                studentId = generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        return studentId;
    }

    private void insertLectionRecord(Connection connection, Long courseId, Long studentId, Lection lection) throws SQLException {
        String insertLectionSQL = "insert into LECTION(COURSE_ID, STUDENT_ID, " +
                "LECTION_DTM, IS_PRESENT, MARK) values (?,?,?,?,?)";
        PreparedStatement lectionInsertStatement = connection.prepareStatement(insertLectionSQL);
        lectionInsertStatement.setLong(1, courseId);
        lectionInsertStatement.setLong(2, studentId);
        Timestamp timestamp = new Timestamp(lection.getDate());
        lectionInsertStatement.setTimestamp(3, timestamp);
        lectionInsertStatement.setBoolean(4, lection.getPresence());
        if (lection.getMark() != null) {
            lectionInsertStatement.setByte(5, lection.getMark());
        } else {
            lectionInsertStatement.setNull(5, Types.TINYINT);
        }

        lectionInsertStatement.executeUpdate();
    }

    private Long insertCourseRecord(Course model, Connection connection) throws SQLException {
        Long courseId = null;
        String sql = "insert into COURSE(TITLE, TEACHER, DTF) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, model.getCourseName());
        statement.setString(2, model.getTeacher());
        statement.setString(3, model.getDateFormat());
        statement.executeUpdate();

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                courseId = generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        return courseId;
    }

    private void cleanDatabase() throws SQLException {
        Connection connection = null;
        try {
            connection = DBUtil.acquireConnection();

            connection.createStatement().executeUpdate("delete from LECTION");
            connection.createStatement().executeUpdate("delete from STUDENT");
            connection.createStatement().executeUpdate("delete from COURSE");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}