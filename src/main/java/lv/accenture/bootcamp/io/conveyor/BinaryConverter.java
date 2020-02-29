package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.io.model.Course;
import lv.accenture.bootcamp.io.model.Lection;
import lv.accenture.bootcamp.io.model.Student;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component("BinaryConverter")
public class BinaryConverter implements Converter {

    @Override
    public Course readFromFile(String path) throws Exception {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        String courseName = readString(dataInputStream);
        String teacherName = readString(dataInputStream);
        String dateFormat = readString(dataInputStream);
        int studentCount = dataInputStream.readInt();
        int lectionCount = dataInputStream.readInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            String studentFirstName = readString(dataInputStream);
            String studentLastName = readString(dataInputStream);
            byte studentAge = dataInputStream.readByte();
            String practiseCompany = readString(dataInputStream);

            List<Lection> dailyReports = new ArrayList<>(lectionCount);
            for (int j = 0; j < lectionCount; j++) {
                long date = dataInputStream.readLong();
                boolean presence = dataInputStream.readBoolean();
                byte rawMark = dataInputStream.readByte();
                Lection dailyReport = new Lection(
                        date, presence, rawMark != -1 ? rawMark : null
                );
                dailyReports.add(dailyReport);

            }

            Student student = new Student(studentFirstName, studentLastName, studentAge, practiseCompany);
            student.setDailyReports(dailyReports);
            students.add(student);
        }

        Course course = new Course(courseName, teacherName, dateFormat, students);
        return course;
    }

    private String readString(DataInputStream dataInputStream) throws IOException {
        int courseNameLength = dataInputStream.readInt();
        byte[] courseNameBytes = new byte[courseNameLength];
        dataInputStream.read(courseNameBytes);
        return new String(courseNameBytes, StandardCharsets.US_ASCII);
    }

    @Override
    public void writeToFile(Course model, String path) {
        throw new UnsupportedOperationException();
    }

}
