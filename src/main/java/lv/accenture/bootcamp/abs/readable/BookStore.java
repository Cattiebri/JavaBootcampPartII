package lv.accenture.bootcamp.abs.readable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookStore {

    public static void main(String[] args) {

        List<String> multipleAuthors = new ArrayList<>();
        multipleAuthors.add("Oscar Wilde");
        multipleAuthors.add("Alexander Pushkin");

        Readable journal = new Journal("Forbes", "Successful success...", "Forbes Media");
        Readable fictionBook = new Fiction("The Picture of Dorian Gray",
                "A lot of text inside", multipleAuthors, "novel");
        Readable nonFictionBook = new NonFiction("Thinking, Fast and Slow", "Subj.",
                Collections.singletonList("Daniel Kahneman"), new ArrayList<String>(), "GTD");

        System.out.println("journal = " + journal.describe());
        System.out.println("fictionBook = " + fictionBook.describe());
        System.out.println("nonFictionBook = " + nonFictionBook.describe());

    }

}
