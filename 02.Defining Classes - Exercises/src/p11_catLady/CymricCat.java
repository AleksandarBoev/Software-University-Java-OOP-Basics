package p11_catLady;

public class CymricCat extends Cat {
    private static final String BREED = "Cymric";

    private double furLength;

    public CymricCat(String name, double furLength) {
        setName(name);
        setFurLength(furLength);
    }


    public double getFurLength() {
        return this.furLength;
    }

    public String getBreed() {
        return BREED;
    }

    private void setFurLength(double furLength) {
        if (furLength <= 0) {
            throw new IllegalArgumentException(String.format(INPUT_LESS_THAN_OR_EQUAL_TO_ZERO, "Fur length"));
        }

        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getBreed(), this.name, this.furLength);
    }
}
