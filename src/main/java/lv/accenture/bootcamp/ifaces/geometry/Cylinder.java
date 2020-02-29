package lv.accenture.bootcamp.ifaces.geometry;

public class Cylinder extends Round implements VolumetricFigure {

    private double height;

    public Cylinder(double radius, double height) throws CheckedGeometricException {
        super(radius);
        this.height = height;
        if(radius < 0 || height < 0) {
            throw new CheckedGeometricException("Radius or height are negative!");
        }
    }

    @Override
    public double volume() {
        return new Circle(radius).area() * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
