package p01_person;

public class Person {
    protected static final String NEGATIVE_AGE_MESSAGE = "Age must be positive!";
    protected static final String LESS_THAN_THREE_SYMBOLS_NAME = "Name's length should not be less than 3 symbols!";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age); // in the Child class this constructor is used, but the overrided setAge is used.
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(LESS_THAN_THREE_SYMBOLS_NAME);
        }

        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException(NEGATIVE_AGE_MESSAGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}
