package p02_salaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        Person[] people = new Person[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++) {
            String[] personTokens = reader.readLine().split(" ");

            String firstName = personTokens[0];
            String lastName = personTokens[1];
            int age = Integer.parseInt(personTokens[2]);
            double initialSalary = Double.parseDouble(personTokens[3]);

            Person currentPerson = new Person(firstName, lastName, age, initialSalary);
            people[i] = currentPerson;
        }
        Person.setBonus(Double.parseDouble(reader.readLine()));
        reader.close();

        for (int i = 0; i < numberOfInputs; i++) {
            people[i].increaseSalary();
            System.out.println(people[i]);
        }

        //main ends here
    }
}
