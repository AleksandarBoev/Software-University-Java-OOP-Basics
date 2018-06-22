package p02_methodOverriding;

public class Square extends Rectangle {
    private Square(double side1, double side2) {
        super(side1, side2);
    }

    public Square(double side) {
        super(side);
    }

    @Override
    public double getArea() {
        return this.side1 * this.side1;
    }
}
