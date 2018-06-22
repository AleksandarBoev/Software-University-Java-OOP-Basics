package p02_methodOverriding;

public class Rectangle {
    protected double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    protected Rectangle(double side) {
        this.side1 = side;
    }

    public double getArea() {
        return this.side1 * this.side2;
    }
}
