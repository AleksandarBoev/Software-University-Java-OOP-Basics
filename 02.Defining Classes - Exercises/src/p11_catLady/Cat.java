package p11_catLady;

import java.util.HashSet;
import java.util.Set;

public class Cat {
    protected final static String INPUT_LESS_THAN_OR_EQUAL_TO_ZERO = "%s can not be less than or equal to zero!";
    private final static String INCORRECT_NAME_MESSAGE = "Incorrect name!";
    private final static String INCORRECT_BREED_MESSAGE = "Incorrect breed!";
    private final static Set<String> CORRECT_BREEDS = new HashSet<>() {{
        add("Cymric");
        add("StreetExtraordinaire");
        add("Siamese");
    }};

    protected String name;

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if (name.trim().isEmpty()) { // || !name.matches("^[A-Z][a-z]+ ?([A-Z][a-z]+)?$"
            throw new IllegalArgumentException(INCORRECT_NAME_MESSAGE);
        }

        this.name = name;
    }

    public static void evaluateBreed(String breed) {
        if (!CORRECT_BREEDS.contains(breed)) {
            throw new IllegalArgumentException(INCORRECT_BREED_MESSAGE);
        }
    }
}
