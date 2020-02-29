package lv.accenture.bootcamp.threads;

public class ArrayFiller {

    public static final int SLEEP_TIME = 5;

    private int[] arrayToFill;


    public static void main(String[] args) throws InterruptedException {
        ArrayFiller arrayFiller = new ArrayFiller();
        arrayFiller.fillArray();
    }

    private void fillArray() {
        for (int i = 0; i < 50; i++) {
            this.arrayToFill = new int[30];

        }
    }



}
