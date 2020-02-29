package lv.accenture.bootcamp.abs.readable;

import java.util.List;

public abstract class AbstractBook extends AbstractReadable {

    protected List<String> authors;

    public AbstractBook(String name, String text, List<String> authors) {
        super(name, text);
        this.authors = authors;
    }

    abstract String type();
}
