package p02_classBoxDataValidation;

public class Box {
    private static String INVALID_LENGTH_EXCEPTION = "Length cannot be zero or negative.";
    private static String INVALID_WIDTH_EXCEPTION = "Width cannot be zero or negative.";
    private static String INVALID_HEIGHT_EXCEPTION = "Height cannot be zero or negative.";

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION);
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(INVALID_WIDTH_EXCEPTION);
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(INVALID_HEIGHT_EXCEPTION);
        }
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
