package lv.accenture.bootcamp.ifaces.geometry;

public class Rectangle implements FlatFigure {

    private Elements.Point a;
    private Elements.Point b;
    private Elements.Point c;
    private Elements.Point d;

    public Rectangle(Elements.Point a, Elements.Point b, Elements.Point c, Elements.Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        double acLength = new Elements.Line(a, c).length();
        double bdLength = new Elements.Line(b, d).length();
        if(acLength != bdLength) {
            throw new UnCheckedGeometricException("Not a rectangle!");
        }
    }

    @Override
    public double perimeter() {
        Elements.Line ab = new Elements.Line(a,b);
        double abLength = ab.length();

        Elements.Line ad = new Elements.Line(a,d);
        double adLength = ad.length();

        return (abLength + adLength) * 2;
    }

    @Override
    public double area() {
        Elements.Line ab = new Elements.Line(a,b);
        double abLength = ab.length();

        Elements.Line ad = new Elements.Line(a,d);
        double adLength = ad.length();
        return abLength * adLength;
    }

    public Elements.Point getA() {
        return a;
    }

    public Elements.Point getB() {
        return b;
    }

    public Elements.Point getC() {
        return c;
    }

    public Elements.Point getD() {
        return d;
    }
}
