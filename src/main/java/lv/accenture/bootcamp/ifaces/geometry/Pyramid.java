package lv.accenture.bootcamp.ifaces.geometry;

public abstract class Pyramid implements VolumetricFigure {

    protected double height;

    public Pyramid(double height) {
        this.height = height;
    }

    @Override
    public double volume() {
        return (1 / 3d) * getBasement().area() * height;
    }

    protected abstract FlatFigure getBasement();
}
