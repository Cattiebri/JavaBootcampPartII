package lv.accenture.bootcamp.ifaces.geometry;

public class Cone extends Pyramid {

    private Circle basement;

    public Cone(Circle basement, double height) {
        super(height);
        this.basement = basement;
    }

    @Override
    protected FlatFigure getBasement() {
        return basement;
    }

    @Override
    public double surfaceArea() {
        double l = Math.sqrt(Math.pow(basement.getRadius(), 2) + Math.pow(height, 2));
        return Math.PI * basement.getRadius() * (basement.getRadius() + l);
    }
}
