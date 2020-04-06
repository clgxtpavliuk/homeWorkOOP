package triangleTask;

public class TestTriangle {
    public static void main(String[] args) {
        try {
            Point a = new Point(2,3);
            Point b = new Point(4,5);
            Point c = new Point(6,7);
            Triangle t = new Triangle(a, b, c);
            System.out.println(t.getArea());
        } catch (SelfIntersectingTriangleException e) {
            System.out.println("Triangle is self-intersection");
        }

    }
}
