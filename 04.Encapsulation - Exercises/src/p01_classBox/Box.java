package p01_classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private double getSurfaceArea() {
        return 2 * (this.width * this.length + this.width * this.height + this.height * this.length);
    }

    public String getSurfaceAreaAnswer() {
        return String.format("Surface Area - %.2f", this.getSurfaceArea());
    }

    private double getLateralSurfaceArea() {
        return 2 * this.height * (this.length + this.width);
    }

    public String getLateralSurfaceAreaAnswer() {
        return String.format("Lateral Surface Area - %.2f", this.getLateralSurfaceArea());
    }

    private double getVolume() {
        return this.length * this.width * this.height;
    }

    public String getVolumeAnswer() {
        return String.format("Volume - %.2f", this.getVolume());
    }
}
