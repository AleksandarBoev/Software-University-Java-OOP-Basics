package p03_shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);

        setPerimeter();
        setArea();
    }

    private final double getHeight() { // don't see the use of it being final in this task...
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private final double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return this.getHeight() * 2 + this.getWidth() * 2;
    }

    @Override
    public double calculateArea() {
        return this.height * this.width;
    }

    @Override
    protected String getShapeName() {
        return "Rectangle";
    }
}
