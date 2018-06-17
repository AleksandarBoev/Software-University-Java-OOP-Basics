package p03_validationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] personTokens = reader.readLine().split(" ");

            String firstName = personTokens[0];
            String lastName = personTokens[1];
            int age = Integer.parseInt(personTokens[2]);
            double salary = Double.parseDouble(personTokens[3]);

            try {
                Person currentPerson = new Person(firstName, lastName, age, salary);
                people.add(currentPerson);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        Person.setBonus(Double.parseDouble(reader.readLine()));
        reader.close();

        for (Person person : people) {
            person.increaseSalary();
            System.out.println(person);
        }

        //main ends here
    }
}
