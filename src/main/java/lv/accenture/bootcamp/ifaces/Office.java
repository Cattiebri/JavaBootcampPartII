package lv.accenture.bootcamp.ifaces;

import lv.accenture.bootcamp.exc.WorkException;

public class Office {

    public static void main(String[] args) {
        Employee employee = new EmployeeImpl("Janis Berzinsh");

        try {
            System.out.println("Work done : " + employee.work(8)
                    + " by employee " + employee.getName());
        } catch (WorkException e) {
            System.out.println("work is not done : " + e.getMessage());
        }

        Employee developer = new Developer("Vasya Pupkin");
        Employee manager = new Manager("Pupka Vasykin");
        Employee srDeveloper = new SrDeveloper("Jack Sparrow");

        System.out.println("developer.getName() = " + developer.getName());
        System.out.println("manager.getName() = " + manager.getName());
        System.out.println("srDeveloper.getName() = " + srDeveloper.getName());

        try {
            ((EmployeeImpl)developer).setAge(-5);
        } catch (IllegalArgumentException e) {
            ((EmployeeImpl)developer).setAge(5);
        }

        System.out.println(((EmployeeImpl)developer).getAge());

        try {
            developer.work(9);
            //developer.work(-2);
        } catch (WorkException e) {
            System.out.println("Developer is overworked, pay overtimes : " + e.getMessage());
        }

        developer.sleep();
    }

}
