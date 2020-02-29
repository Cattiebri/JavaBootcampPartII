package lv.accenture.bootcamp.ifaces;

public class Cat implements Animal {

    @Override
    public void speak() {
       System.out.println("Meow!");
    }

    public void sleep() {
        System.out.println("Cat sleeps!");
    }

}
