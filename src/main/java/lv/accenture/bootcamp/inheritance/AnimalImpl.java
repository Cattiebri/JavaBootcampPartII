package lv.accenture.bootcamp.inheritance;

import lv.accenture.bootcamp.ifaces.Animal;

public class AnimalImpl implements Animal {

    @Override
    public void speak() {
        System.out.println("Animal speaks...");
    }

    @Override
    public void sleep() {
        System.out.println("Animal sleeps... (Zzzz...)");
    }
}
