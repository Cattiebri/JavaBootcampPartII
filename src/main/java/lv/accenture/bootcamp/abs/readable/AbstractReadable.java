package lv.accenture.bootcamp.abs.readable;

public abstract class AbstractReadable implements Readable {

    private String name;
    private String text;

    public AbstractReadable(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String name() {
        return name;
    }

    public String text() {
        return text;
    }
}
