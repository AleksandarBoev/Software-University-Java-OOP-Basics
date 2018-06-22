package p06_animals;

public class Tomcat extends Cat{

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!"Male".equals(gender)) {
            throw new IllegalArgumentException(super.INVALID_INPUT_MESSAGE);
        }

        super.setGender(gender);
    }

    @Override
    protected String getSpecies() {
        return "Tomcat";
    }

    @Override
    protected String produceSound() {
        return "Give me one million b***h";
    }
}
