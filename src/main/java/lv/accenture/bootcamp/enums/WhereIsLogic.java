package lv.accenture.bootcamp.enums;

import java.util.HashMap;

public class WhereIsLogic {

    public static void main(String[] args) {
        boolean someFact = true;
        boolean fiveMoreThanThree = 5 > 3;

        System.out.println("fiveMoreThanThree = " + fiveMoreThanThree);

        String s = "some";
        boolean equals = s.equals("some");
        System.out.println("equals = " + equals);

        String s2 = null;
        boolean isNull = (s2 == null);
        System.out.println("isNull = " + isNull);

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "January");

        String january = hashMap.get(1);
        boolean hasValue = (january != null);
        System.out.println("hasValue = " + hasValue);

        String unknownMonth = hashMap.get(2);
        System.out.println("unknownMonth = " + unknownMonth);

        boolean hasNoValue = (unknownMonth == null);
        System.out.println("hasNoValue = " + hasNoValue);
    }

}
