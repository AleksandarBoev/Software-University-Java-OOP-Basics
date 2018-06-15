package p01_sortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfLines = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = reader.readLine().split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer age = Integer.parseInt(tokens[2]);

            Person currentPerson = new Person(firstName, lastName, age);
            people.add(currentPerson);
        }

        people.stream()
                .sorted((p1, p2) -> {
                    int comparisonResult = p1.getFirstName().compareTo(p2.getFirstName());

                    if (comparisonResult != 0) {
                        return comparisonResult;
                    } else {
                        return p1.getAge().compareTo(p2.getAge());
                    }
                }).forEach(p -> System.out.println(p));
        //main ends here
    }
}
