package p11_catLady;

public class StreetExtraordinaire extends Cat{
    private static final String BREED = "StreetExtraordinaire";

    private double meowDecibels;

    public StreetExtraordinaire(String name, double meowDecibels) {
        this.setName(name);
        setMeowDecibels(meowDecibels);
    }

    private void setMeowDecibels(double meowDecibels) {
        if (meowDecibels <= 0) {
            throw new IllegalArgumentException(String.format(INPUT_LESS_THAN_OR_EQUAL_TO_ZERO, "Meow decibels"));
        }

        this.meowDecibels = meowDecibels;
    }

    public String getBreed() {
        return BREED;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), this.name, this.meowDecibels);
    }
}
