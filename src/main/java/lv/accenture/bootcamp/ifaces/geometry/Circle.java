package lv.accenture.bootcamp.ifaces.geometry;

public class Circle extends Round implements FlatFigure {

    public Circle(double radius) {
        super(radius);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
