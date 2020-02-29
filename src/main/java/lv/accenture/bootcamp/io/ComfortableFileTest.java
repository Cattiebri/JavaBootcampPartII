package lv.accenture.bootcamp.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ComfortableFileTest {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("./documents/words-2.txt");
        List<String> lines = Arrays.asList("Hello", "World", "!");
        Files.write(path, lines);

        List<String> fileData = Files.readAllLines(path);
        System.out.println("fileData = " + fileData);

        String s = "42";
        int i = Integer.parseInt(s);
        System.out.println("i + 1 = " + (i + 1));

    }

}
