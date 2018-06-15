package p09_google;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            //•	“<Name> company <companyName> <department> <salary>”
            //•	“<Name> pokemon <pokemonName> <pokemonType>”
            //•	“<Name> parents <parentName> <parentBirthday>”
            //•	“<Name> children <childName> <childBirthday>”
            //•	“<Name> car <carModel> <carSpeed>”

            String[] tokens = input.split(" ");

            String personName = tokens[0];
            if (!people.containsKey(personName)) {
                Person person = new Person(personName);
                people.put(personName, person);
            }

            if ("company".equals(tokens[1])) {
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                Company currentCompany = new Company(companyName, department, salary);
                people.get(personName).setCompany(currentCompany);
            } else if ("pokemon".equals(tokens[1])) {
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                Pair<String, String> currentPokemonNameType = new Pair<>(pokemonName, pokemonType);
                people.get(personName).getPokemonsNameType().add(currentPokemonNameType);
            } else if ("parents".equals(tokens[1])) {
                String parentName = tokens[2];
                String parentBirthday = tokens[3];

                Pair<String, String> currentParent = new Pair<>(parentName, parentBirthday);
                people.get(personName).getParentsNameBirthday().add(currentParent);
            } else if ("children".equals(tokens[1])) {
                String childName = tokens[2];
                String childBirthday = tokens[3];

                Pair<String, String> currentChild = new Pair<>(childName, childBirthday);
                people.get(personName).getChildrenNameBirthday().add(currentChild);
            } else if ("car".equals(tokens[1])) {
                String carModel = tokens[2];
                String carSpeed = tokens[3];

                Pair<String, String> carModelSpeed = new Pair<>(carModel, carSpeed);
                people.get(personName).setCarNameSpeed(carModelSpeed);
            }
        }

        String printInfoOnThisPerson = reader.readLine();
        reader.close();

        System.out.println(people.get(printInfoOnThisPerson));

        //main ends here
    }
}
