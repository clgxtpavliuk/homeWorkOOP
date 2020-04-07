package hometask2.shapeTask;

public class Area extends Shape {
    @Override
    public void rectangleArea(int length, int breadth) {
        int area = length*breadth;
        System.out.println("Rectangle area = " + area);
    }

    @Override
    public void squareArea(int side) {
        int area = side*side;
        System.out.println("Square area = " + area);
    }

    @Override
    public void circleArea(int radius) {
        double area = Math.PI*radius*radius;
        System.out.println("Circle area = " + area);
    }
}
