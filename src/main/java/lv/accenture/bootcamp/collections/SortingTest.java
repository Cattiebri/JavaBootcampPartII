package lv.accenture.bootcamp.collections;

import lv.accenture.bootcamp.inheritance.LazyDomesticCat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTest {

    public static void main(String[] args) {
        List<LazyDomesticCat> lazyDomesticCats = new ArrayList<>();
        lazyDomesticCats.add(new LazyDomesticCat("Prince" ,237465));
        lazyDomesticCats.add(new LazyDomesticCat("Muris", 598674));
        lazyDomesticCats.add(new LazyDomesticCat("Nikija", 230495));

        Collections.sort(lazyDomesticCats, new ChipIdComparator());

        System.out.println("lazyDomesticCats = " + lazyDomesticCats);
    }

    private static class ChipIdComparator implements Comparator<LazyDomesticCat> {

        @Override
        public int compare(LazyDomesticCat o1, LazyDomesticCat o2) {
            return Integer.compare(o1.getChipId(), o2.getChipId());
        }

    }

}
