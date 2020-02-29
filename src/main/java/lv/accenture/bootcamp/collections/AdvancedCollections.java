package lv.accenture.bootcamp.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AdvancedCollections {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("watermelon");
        list.add("pomegrenate");
        list.add("raspberry");
        list.add("mango");

        list.remove("watermelon");
        System.out.println("list = " + list);

        int appleIndex = list.indexOf("apple");
        if(appleIndex != -1) {
            list.remove(appleIndex);
        }

        System.out.println("list = " + list);

        list.add("apple (gala)");
        list.add("apple (fuji)");
        list.add("apple (Granny Smith)");
        System.out.println("list = " + list);

        // BAD CODE!!!
        /*for (int i = 0; i < list.size(); i++) {
            String fruit = list.get(i);
            if(fruit.startsWith("apple")) {
                list.remove(i);
            }
        }*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            //System.out.println("fruit = " + fruit);
            if (fruit.startsWith("apple")) {
                iterator.remove();
            }
        }

        System.out.println("list = " + list);

        Collections.sort(list);

        System.out.println("list = " + list);
    }

}
