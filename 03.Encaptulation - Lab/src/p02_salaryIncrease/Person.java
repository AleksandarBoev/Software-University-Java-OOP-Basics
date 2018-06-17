package p02_salaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;
    private static double bonusToSalary;
    private static DecimalFormat df = new DecimalFormat("#.0################################");

    public Person(String firstName, String lastName, Integer age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Integer getAge() {
        return this.age;
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
