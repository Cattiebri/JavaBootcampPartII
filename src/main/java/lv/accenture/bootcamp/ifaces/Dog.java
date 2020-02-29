package lv.accenture.bootcamp.ifaces;

public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps!");
    }
}
