package p03_animalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private static final String INVALID_NAME_EXCEPTION = "Name cannot be empty.";
    private static final String INVALID_AGE_EXCEPTION = "Age should be between 0 and 15.";

    private String name;
    private int age;
    private double eggsPerDay;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setEggsPerDay();
    }

    private void setName(String name) {
        if (name.length() < 1 || name == null || name.matches("\\s+")) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION);
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException(INVALID_AGE_EXCEPTION);
        }

        this.age = age;
    }

    private void setEggsPerDay() {
        if (this.age <= 5) {
            this.eggsPerDay = 2;
        } else if (this.age <= 11) {
            this.eggsPerDay = 1;
        } else {
            this.eggsPerDay = 0.75;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#################");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.name, this.age, df.format(this.eggsPerDay));
    }
}
