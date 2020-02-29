package lv.accenture.bootcamp.inheritance;

import java.util.Objects;

public class DomesticCat extends AbstractCat implements Comparable<DomesticCat> {

    protected String name;

    public DomesticCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("Cat " + name + " is sleeping");

        super.groom();
        groom();
    }

    public void groom() {
        System.out.println("Cat " + name + " is grooming");
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof DomesticCat) {
            DomesticCat that = (DomesticCat) o;
            return name.equals(that.name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "DomesticCat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(DomesticCat that) {
        return this.name.compareTo(that.name);
    }
}
