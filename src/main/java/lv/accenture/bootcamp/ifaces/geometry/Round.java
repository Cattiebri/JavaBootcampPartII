package lv.accenture.bootcamp.ifaces.geometry;

public abstract class Round {

    protected double radius;

    public Round(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
