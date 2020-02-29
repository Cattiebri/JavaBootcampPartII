package lv.accenture.bootcamp.io.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BookIO {

    public static void main(String[] args) throws Exception {
        Book book = new Book("Learn Java in 160h", 100500);
        List<Author> authors = Arrays.asList(
                new Author("V.", "Pupkin"),
                new Author("P.", "Vasykin")
        );
        book.setAuthors(authors);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String bookJSON = gson.toJson(book);

        Path path = Paths.get("./documents/book.json");
        Files.write(path, bookJSON.getBytes(StandardCharsets.UTF_8));


        String inputJSON = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Book bookFromJSON = gson.fromJson(inputJSON, Book.class);

        System.out.println("Books are same : " + bookFromJSON.equals(book));
    }

}
