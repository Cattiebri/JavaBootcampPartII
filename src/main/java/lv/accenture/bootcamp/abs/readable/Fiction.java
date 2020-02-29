package lv.accenture.bootcamp.abs.readable;

import java.util.List;

public class Fiction extends AbstractBook {

    private String genre;

    public Fiction(String name, String text, List<String> authors, String genre) {
        super(name, text, authors);
        this.genre = genre;
    }

    @Override
    String type() {
        return "Fiction";
    }

    @Override
    public String describe() {
        return authors + " : " + name() + " (" + genre + ")";
    }
}
