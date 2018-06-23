package p03_shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        setRadius(radius);

        setPerimeter();
        setArea();
    }

    private final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    protected String getShapeName() {
        return "Circle";
    }

}
