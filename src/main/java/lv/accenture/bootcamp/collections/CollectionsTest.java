package lv.accenture.bootcamp.collections;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(-12);
        list.add(7);
        list.add(5);
        System.out.println("list = " + list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(-12);
        set.add(7);
        set.add(5);
        System.out.println("set = " + set);

        Set<Integer> orderedSet = new LinkedHashSet<>();
        orderedSet.add(1);
        orderedSet.add(5);
        orderedSet.add(-12);
        orderedSet.add(7);
        orderedSet.add(5);
        System.out.println("orderedSet = " + orderedSet);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(1, "one-one");
        System.out.println("map = " + map);

        Map<Integer, String> orderedMap = new LinkedHashMap<>();
        orderedMap.put(2, "two");
        orderedMap.put(1, "one");
        orderedMap.put(3, "three");
        orderedMap.put(1, "one-one");
        System.out.println("orderedMap = " + orderedMap);

        String value = map.get(1);
        System.out.println("value = " + value);

        value = map.get(5);
        System.out.println("value = " + value);

        System.out.println("\n");

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            String val = map.get(key);
            System.out.println(key + " -> " + val);
        }

        String longText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in velit tincidunt odio aliquet luctus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus finibus eget nisl quis vulputate. Pellentesque ac tincidunt nisl, eget laoreet quam. Vestibulum non ante sit amet nibh varius volutpat. Nulla ac elit dolor. Integer nisl ante, luctus sit amet purus faucibus, rhoncus luctus dui. Phasellus massa velit, lobortis consequat tortor vel, consectetur bibendum purus. Donec nec metus non turpis tempor egestas. Maecenas euismod luctus aliquam.\n" +
                "Nullam bibendum, odio ut ultrices scelerisque, orci neque tempor urna, eget consequat eros tellus non dolor. Integer ac vulputate mauris, at eleifend sapien. Quisque ut eros vel justo viverra luctus. Ut a interdum nisl. Nullam at consectetur lorem, in tristique nisi. Cras non ornare diam. Suspendisse diam erat, semper ut rutrum at, auctor vel sapien. Curabitur viverra, nisl in porta pellentesque, metus turpis posuere ipsum, sit amet tincidunt dui nisl at justo. Phasellus in elit dapibus, placerat dolor id, pulvinar dolor.\n" +
                "Aliquam in orci non diam rhoncus consequat. Donec quis imperdiet ipsum. Fusce id sem vel leo vestibulum gravida. Aliquam nec facilisis risus, sit amet fringilla magna. Aenean ut leo hendrerit, pharetra ex vel, aliquam justo. Morbi auctor neque justo, eu convallis nisl sodales eget. Curabitur sodales nec sapien vel porttitor. Mauris scelerisque tellus massa, sed blandit nulla accumsan sed. Maecenas bibendum dui eu nisi facilisis, ut faucibus ante dignissim.\n" +
                "Suspendisse blandit vehicula tempor. Cras ac consectetur turpis. Curabitur eleifend quam vitae aliquam consequat. Suspendisse ut pharetra felis. Donec pellentesque dapibus auctor. Nulla facilisi. Vivamus convallis sollicitudin tellus nec vulputate. Proin malesuada tellus quis leo rutrum iaculis.\n" +
                "Integer tincidunt massa id nulla pulvinar malesuada. Donec elit nunc, tempus vitae tortor rutrum, commodo malesuada neque. Mauris at pellentesque nunc. Mauris et tortor eros. Duis ut auctor libero. Nunc a magna nulla. Etiam ornare erat eget pellentesque tempus. Vivamus vehicula tempus ipsum, nec tincidunt enim. Etiam et turpis semper diam vulputate condimentum vitae quis felis. Nunc congue egestas lectus quis interdum.";

        String[] words = longText.split(" ");
        Map<String, Integer> wordCounter = new HashMap<>();
        for(String word : words) {
            Integer currentCount = wordCounter.get(word);
            if(currentCount == null) {
                wordCounter.put(word, 1);
            } else {
                wordCounter.put(word, currentCount + 1);
            }
        }

        Set<String> wordkeySet = wordCounter.keySet();
        for(String wordKey : wordkeySet) {
            Integer val = wordCounter.get(wordKey);
            System.out.println(wordKey + " -> " + val);
        }
    }

}
