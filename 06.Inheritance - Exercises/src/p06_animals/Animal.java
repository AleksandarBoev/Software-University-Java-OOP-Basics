package p06_animals;

import java.util.Set;

public class Animal {
    protected static final String INVALID_INPUT_MESSAGE = "Invalid input!";
    public static final Set<String> ALLOWED_SPECIES = Set.of("animal", "cat", "dog", "frog", "kitten", "tomcat");

    private String animalType;
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {
        if ("".equals(name.trim()) || name.matches("^\\[A-z\\]+$]")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.age = age;
    }

    protected void setGender(String gender) {
        if (!"Male".equalsIgnoreCase(gender) && !"Female".equalsIgnoreCase(gender)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.gender = gender;
    }

    protected String produceSound() {
        return "Not implemented!";
    }

    public static String getInvalidInputMessage() {
        return INVALID_INPUT_MESSAGE;
    }

    protected String getSpecies() {
        return "Animal";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getSpecies()).append(System.lineSeparator());
        sb.append(this.name).append(' ').append(this.age).append(' ').append(this.gender).append(System.lineSeparator());
        sb.append(this.produceSound());

        return sb.toString();
    }
}
