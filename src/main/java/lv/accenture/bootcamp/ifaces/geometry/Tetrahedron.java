package lv.accenture.bootcamp.ifaces.geometry;

public class Tetrahedron extends Pyramid {

    private Triangle basement;

    public Tetrahedron(Triangle basement, double height) {
        super(height);
        this.basement = basement;
    }

    @Override
    protected FlatFigure getBasement() {
        return basement;
    }

    @Override
    public double surfaceArea() {
        double basementSideLength = basement.perimeter() / 3d;
        return Math.sqrt(3) * Math.pow(basementSideLength, 2) ;
    }
}
