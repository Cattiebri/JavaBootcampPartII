package lv.accenture.bootcamp.io.xml;

public class Person {

    private String name;
    private String surname;
    private int ageYears;
    private DomesticAnimal domesticAnimal;

    public Person(String name, String surname, int ageYears, DomesticAnimal domesticAnimal) {
        this.name = name;
        this.surname = surname;
        this.ageYears = ageYears;
        this.domesticAnimal = domesticAnimal;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public DomesticAnimal getDomesticAnimal() {
        return domesticAnimal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ageYears=" + ageYears +
                ", domesticAnimal=" + domesticAnimal +
                '}';
    }
}
