package lv.accenture.bootcamp.ifaces;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat();
	    cat.speak();

        Animal dog = new Dog();
	    dog.speak();

        Animal employee = new EmployeeImpl("Janis Berzinsh");

        List<Animal> zoo = new ArrayList<>();
        zoo.add(cat);
        zoo.add(dog);
        zoo.add(employee);

        for (Animal animal : zoo) {
            animal.sleep();
        }
    }
}
