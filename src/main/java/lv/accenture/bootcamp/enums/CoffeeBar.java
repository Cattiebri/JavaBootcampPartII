package lv.accenture.bootcamp.enums;

public class CoffeeBar {

    class Cup {
        private CupSize size;

        public Cup(CupSize size) {
            this.size = size;
        }
    }

    public static void main(String[] args) {
        CoffeeBar coffeeBar = new CoffeeBar();
        Cup cup = coffeeBar.new Cup(CupSize.MEDIUM);

        String cupSizeName = cup.size.name();
        System.out.println(cupSizeName);

        int ordinal = CupSize.LARGE.ordinal();
        System.out.println("ordinal = " + ordinal);

        CupSize[] cupSizes = CupSize.values();

    }


}
