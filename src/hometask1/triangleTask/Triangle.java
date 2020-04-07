package hometask1.triangleTask;

public class Triangle {
    private double abSide;
    private double bcSide;
    private double caSide;

    public Triangle (Point a, Point b, Point c) {
        abSide = Math.sqrt((b.getX() - a.getX())*(b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY()));
        bcSide = Math.sqrt((c.getX() - b.getX())*(c.getX() - b.getX()) + (c.getY() - b.getY())*(c.getY() - b.getY()));
        caSide = Math.sqrt((a.getX() - c.getX())*(a.getX() - c.getX()) + (a.getY() - c.getY())*(a.getY() - c.getY()));
    }

    public double getArea () throws SelfIntersectingTriangleException {
        if (abSide >= bcSide + caSide || bcSide >= abSide + caSide || caSide >= abSide + bcSide) {
throw new SelfIntersectingTriangleException();
        } else {
            double halfPerimeter = (abSide + bcSide + caSide) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - abSide) * (halfPerimeter - bcSide) * (halfPerimeter - caSide));
        }
    }

}
