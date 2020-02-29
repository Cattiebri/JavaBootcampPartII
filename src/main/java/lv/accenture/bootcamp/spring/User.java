package lv.accenture.bootcamp.spring;

public class User {

    private String fullName;
    private String number;
    private String email;

    public User(String fullName, String number, String email) {
        this.fullName = fullName;
        this.number = number;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }
}
