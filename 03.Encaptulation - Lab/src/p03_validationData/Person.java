package p03_validationData;

import java.text.DecimalFormat;

public class Person {
    private static final String NEGATIVE_OR_EQUAL_TO_ZERO_AGE = "Age cannot be zero or negative integer";
    private static final String FIRST_NAME_ERROR_MESSAGE = "First name cannot be less than 3 symbols";
    private static final String LAST_NAME_ERROR_MESSAGE = "Last name cannot be less than 3 symbols";
    private static final String LOWER_THAN_MINIMUM_WAGE_SALARY_MESSAGE = "Salary cannot be less than 460 leva";

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;
    private static double bonusToSalary;
    private static DecimalFormat df = new DecimalFormat("#.0################################");

    public Person(String firstName, String lastName, Integer age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException(FIRST_NAME_ERROR_MESSAGE);
        }

        this.firstName = firstName;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(NEGATIVE_OR_EQUAL_TO_ZERO_AGE);
        }

        this.age = age;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(LAST_NAME_ERROR_MESSAGE);
        }

        this.lastName = lastName;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException(LOWER_THAN_MINIMUM_WAGE_SALARY_MESSAGE);
        }

        this.salary = salary;
    }


    public static void setBonus(double bonus) {
        bonusToSalary = bonus;
    }

    public void increaseSalary() {
        if (this.age > 30) {
            this.salary += this.salary * bonusToSalary / 100.0;
        } else {
            this.salary += this.salary * bonusToSalary / 200.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, df.format(this.salary));
    }
}
