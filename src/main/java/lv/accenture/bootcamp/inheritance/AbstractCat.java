package lv.accenture.bootcamp.inheritance;

public class AbstractCat extends AnimalImpl {

    public void groom() {
        System.out.println("Cat is grooming");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeps all day long!");
    }
}
