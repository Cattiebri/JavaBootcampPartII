package lv.accenture.bootcamp.ifaces;

public class SrDeveloper extends Developer {

    public SrDeveloper(String name) {
        super(name);
    }

    @Override
    public String getName() {
        if ("Jack Sparrow".equals(name)) {
            return "Captain Jack Sparrow";
        } else {
            return super.getName();
        }
    }
}
