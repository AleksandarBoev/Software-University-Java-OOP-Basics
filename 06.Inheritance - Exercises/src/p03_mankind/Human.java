package p03_mankind;

public class Human {
    private static final String NON_CAPITAL_LETTER_FIRST_NAME_MESSAGE = "Expected upper case letter!Argument: firstName";
    private static final String LESS_THAN_FOUR_LETTERS_FIRST_NAME_MESSAGE = "Expected length at least 4 symbols!Argument: firstName";

    private static final String NON_CAPITAL_LETTER_LAST_NAME_MESSAGE = "Expected upper case letter!Argument: lastName";
    private static final String LESS_THAN_THREE_LETTERS_LAST_NAME_MESSAGE = "Expected length at least 3 symbols!Argument: lastName";

    private String firstName;
    protected String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(NON_CAPITAL_LETTER_FIRST_NAME_MESSAGE);
        }

        if (firstName.length() < 4) {
            throw new IllegalArgumentException(LESS_THAN_FOUR_LETTERS_FIRST_NAME_MESSAGE);
        }

        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(NON_CAPITAL_LETTER_LAST_NAME_MESSAGE);
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException(LESS_THAN_THREE_LETTERS_LAST_NAME_MESSAGE);
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s", this.firstName, this.lastName);
    }
}
