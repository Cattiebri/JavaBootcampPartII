package lv.accenture.bootcamp.io.model;

import java.util.List;
import java.util.Objects;

public class Course {

    private String courseName;

    private String teacher;

    private String dateFormat;

    private List<Student> students;

    public Course(String courseName, String teacher, String dateFormat, List<Student> students) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.dateFormat = dateFormat;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) &&
                Objects.equals(teacher, course.teacher) &&
                Objects.equals(dateFormat, course.dateFormat) &&
                Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, teacher, dateFormat, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ",\n students=" + students +
                '}';
    }
}
