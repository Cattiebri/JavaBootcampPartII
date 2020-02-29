package lv.accenture.bootcamp.ifaces;

import lv.accenture.bootcamp.exc.WorkException;

import java.util.Random;

public class EmployeeImpl implements Employee, Hobby {

    protected String name;
    protected int age;

    public EmployeeImpl (String name) {
        this.name = name;
    }

    public boolean work(int hours) throws WorkException {
        int r = new Random().nextInt(24);
        return r > hours;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 0) {
            throw new IllegalArgumentException("Age can not be negative!");
        }
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println("When friday?");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void spendTime() {
        System.out.println("Spend some time on hobby");
    }

}
