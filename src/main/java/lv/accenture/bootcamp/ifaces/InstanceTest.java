package lv.accenture.bootcamp.ifaces;

import lv.accenture.bootcamp.inheritance.AbstractCat;
import lv.accenture.bootcamp.inheritance.DomesticCat;

public class InstanceTest {

    public static void main(String[] args) {
        Animal cat = new DomesticCat("Prince");
        Animal dog = new Dog();

        /*boolean inst = cat instanceof AbstractCat;
        System.out.println(inst);

        System.out.println(cat instanceof Dog);

        System.out.println(cat instanceof Animal);*/

        boolean equalExact = cat.getClass() == AbstractCat.class;
        System.out.println(equalExact);

        boolean equalsByInstanceOf = cat instanceof AbstractCat;
        System.out.println(equalsByInstanceOf);

        if (cat instanceof AbstractCat) {
            AbstractCat abstractCat = ((AbstractCat) cat);
            abstractCat.groom();
        }


    }

}
