package p06_animals;

public class Kitten extends Cat{

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!"Female".equals(gender)) {
            throw new IllegalArgumentException(super.INVALID_INPUT_MESSAGE);
        }

        super.setGender(gender);
    }

    @Override
    protected String getSpecies() {
        return "Kitten";
    }

    @Override
    protected String produceSound() {
        return "Miau";
    }
}
