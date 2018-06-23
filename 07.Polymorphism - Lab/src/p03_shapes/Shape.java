package p03_shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter() {
        this.perimeter = calculatePerimeter();
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea() {
        this.area = calculateArea();
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    protected abstract String getShapeName();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getShapeName()).append(System.lineSeparator());
        sb.append("Perimeter: ").append(String.format("%.2f", getPerimeter())).append(System.lineSeparator());
        sb.append("Area: ").append(String.format("%.2f", getArea()));

        return sb.toString();
    }
}
