package lv.accenture.bootcamp.ifaces;

import java.util.List;

public class Manager extends EmployeeImpl {

    private List<Developer> workers;

    public Manager(String name) {
        super(name);
    }

    @Override
    public boolean work(int hours) {
        return hours <= 6;
    }

    @Override
    public void speak() {

    }

    @Override
    public void sleep() {

    }
}
