package p11_catLady;

public class SiameseCat extends Cat{
    private static final String BREED = "Siamese";

    private double earSize;

    public SiameseCat(String name, double earSize) {
        setName(name);
        setEarSize(earSize);
    }

    public double getEarSize() {
        return this.earSize;
    }

    public String getBreed() {
        return BREED;
    }

    private void setEarSize(double earSize) {
        if (earSize <= 0) {
            throw new IllegalArgumentException(String.format(INPUT_LESS_THAN_OR_EQUAL_TO_ZERO, "Ear size"));
        }

        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getBreed(), this.name, this.earSize);
    }
}
