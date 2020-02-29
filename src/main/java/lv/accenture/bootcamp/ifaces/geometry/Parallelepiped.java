package lv.accenture.bootcamp.ifaces.geometry;

public class Parallelepiped implements VolumetricFigure {

    private Rectangle basement;
    private double height;

    public Parallelepiped(Rectangle basement, double height) {
        this.basement = basement;
        this.height = height;
    }

    @Override
    public double volume() {
        return basement.area() * height;
    }

    @Override
    public double surfaceArea() {
        Elements.Line lineAD = new Elements.Line(basement.getA(), basement.getD());
        double adHeightArea = lineAD.length() * height;
        Elements.Line lineAB = new Elements.Line(basement.getA(), basement.getB());
        double abHeightArea = lineAB.length() * height;
        return adHeightArea * 2 + abHeightArea * 2 + basement.area() * 2;
    }
}
