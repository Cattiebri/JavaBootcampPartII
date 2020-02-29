package lv.accenture.bootcamp.io.model;

import java.util.List;
import java.util.Objects;

public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private Byte age;

    private String practiseCompany;

    private List<Lection> dailyReports;

    public Student(String firstName, String lastName, Byte age, String practiseCompany) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.practiseCompany = practiseCompany;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Byte getAge() {
        return age;
    }

    public String getPractiseCompany() {
        return practiseCompany;
    }

    public List<Lection> getDailyReports() {
        return dailyReports;
    }

    public void setDailyReports(List<Lection> dailyReports) {
        this.dailyReports = dailyReports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(age, student.age) &&
                Objects.equals(practiseCompany, student.practiseCompany) &&
                Objects.equals(dailyReports, student.dailyReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, practiseCompany, dailyReports);
    }

    @Override
    public String toString() {
        return "\tStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", practiseCompany='" + practiseCompany + '\'' +
                ", \nlections=" + dailyReports +
                "}\n";
    }
}
