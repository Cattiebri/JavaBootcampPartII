package lv.accenture.bootcamp.abs.readable;

import java.util.List;

public class NonFiction extends AbstractBook {

    private List<String> references;
    private String category;

    public NonFiction(String name, String text, List<String> authors, List<String> references, String category) {
        super(name, text, authors);
        this.references = references;
        this.category = category;
    }

    @Override
    String type() {
        return "NonFiction";
    }

    @Override
    public String describe() {
        return authors + " : " + name() + " (" + category + ")";
    }
}
