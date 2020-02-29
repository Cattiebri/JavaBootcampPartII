package lv.accenture.bootcamp.ifaces.geometry;

public class Sphere extends Round implements VolumetricFigure {

    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double volume() {
        return (4 / 3d) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
