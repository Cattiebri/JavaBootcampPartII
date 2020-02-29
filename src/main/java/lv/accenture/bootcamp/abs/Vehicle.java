package lv.accenture.bootcamp.abs;

public abstract class Vehicle implements IVehicle {

    protected double speed = 0;

    public void accelerate(double delta) {
        this.speed += delta;
    }

    public void slowDown(double delta) {
        this.speed -= delta;
    }

    public abstract String getCategory();

}
