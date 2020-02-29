package lv.accenture.bootcamp.ifaces.geometry;

public class Triangle implements FlatFigure {
    private Elements.Point a;
    private Elements.Point b;
    private Elements.Point c;

    public Triangle(Elements.Point a, Elements.Point b, Elements.Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        Elements.Line ab = new Elements.Line(a,b);
        double abLength = ab.length();

        Elements.Line ac = new Elements.Line(a,c);
        double acLength = ac.length();

        Elements.Line bc = new Elements.Line(b,c);
        double bcLength = bc.length();

        double result = abLength + acLength + bcLength;

        return result;
    }

    public double area() {

        Elements.Line ab = new Elements.Line(a,b);
        double abLength = ab.length();

        Elements.Line ac = new Elements.Line(a,c);
        double acLength = ac.length();

        Elements.Line bc = new Elements.Line(b,c);
        double bcLength = bc.length();

        double halfPerimter = perimeter() / 2;

        double area = Math.sqrt(halfPerimter *
                (halfPerimter - abLength) *
                (halfPerimter - acLength) *
                (halfPerimter - bcLength)
        );

        return area;
    }
}
