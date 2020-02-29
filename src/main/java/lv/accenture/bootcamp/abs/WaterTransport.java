package lv.accenture.bootcamp.abs;

public abstract class WaterTransport extends Vehicle {

    @Override
    public String getCategory() {
        return "water";
    }

    public abstract void drown();

}
