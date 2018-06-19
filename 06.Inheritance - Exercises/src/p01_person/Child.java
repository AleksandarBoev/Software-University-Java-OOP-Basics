package p01_person;

public class Child extends Person {
    private static final String OLDER_THAN_15_MESSAGE = "Child's age must be lesser than 15!";

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException(this.OLDER_THAN_15_MESSAGE);
        }

        super.setAge(age);
    }
}
