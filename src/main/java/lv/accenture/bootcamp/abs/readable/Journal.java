package lv.accenture.bootcamp.abs.readable;

public class Journal extends AbstractReadable {

    private final String publisher;

    public Journal(String name, String text, String publisher) {
        super(name, text);
        this.publisher = publisher;
    }

    @Override
    public String describe() {
        return "Journal : " + publisher + " - " + name();
    }
}
