package P03OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());

        Person[] people = new Person[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person currentPerson = new Person(name, age);
            people[i] = currentPerson;
        }
        reader.close();

        Arrays.stream(people)
                .filter(p -> p.getAge() > 30)
                .sorted((p1, p2) -> {
                    return p1.getName().compareTo(p2.getName());
                }).forEach(p -> {
            System.out.printf("%s - %d%n", p.getName(), p.getAge());
        });
        //main ends here
    }
}
