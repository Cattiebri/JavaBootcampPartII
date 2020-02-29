package lv.accenture.bootcamp.ifaces.geometry;

public class Elements {

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static class Line {

        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public double length() {
            int diffX = end.getX() - start.getX();
            int diffY = end.getY() - start.getY();
            double catet1Square = Math.pow(diffX, 2); // diffX * diffX
            double catet2Square = Math.pow(diffY, 2); // diffY * diffY
            return Math.sqrt(catet1Square + catet2Square);
        }

    }
}
