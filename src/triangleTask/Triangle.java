package triangleTask;

public class Triangle {
    private double abSide;
    private double bcSide;
    private double caSide;

    public Triangle (Point a, Point b, Point c) {
        abSide = Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
        bcSide = Math.sqrt((c.x - b.x)*(c.x - b.x) + (c.y - b.y)*(c.y - b.y));
        caSide = Math.sqrt((a.x - c.x)*(a.x - c.x) + (a.y - c.y)*(a.y - c.y));
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
