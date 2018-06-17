package p10_familyTree;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> pairList = new LinkedList<>();
        Map<String, String> allPeopleNameDate = new HashMap<>();

        Map<String, String> parentsNameDate = new LinkedHashMap<>();
        Map<String, String> childrenNameDate = new LinkedHashMap<>();

        String personOfInterest = reader.readLine();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens;

            if (input.contains(" - ")) {
                tokens = input.split(" - ");
                pairList.add(new Pair<>(tokens[0], tokens[1]));
            } else {
                tokens = input.split(" ");
                String firstNameLastName = tokens[0] + " " +  tokens[1];
                String date = tokens[2];
                allPeopleNameDate.put(firstNameLastName, date);
            }
        }

        Map.Entry<String, String> personOfInterestNameDate = null;
        for (Map.Entry<String, String> currentNameDate : allPeopleNameDate.entrySet()) {
            if (currentNameDate.getKey().equals(personOfInterest) || currentNameDate.getValue().equals(personOfInterest)) {
                personOfInterestNameDate = currentNameDate;
                break;
            }
        }

        for (Pair<String, String> stringStringPair : pairList) { //left side of pair = key = Parent
            if (stringStringPair.getKey().equals(personOfInterestNameDate.getKey()) //our guy is the father => other one is a childs info (name of date)
                    || stringStringPair.getKey().equals(personOfInterestNameDate.getValue())) {

                String childInfo = stringStringPair.getValue();
                findAndPut(childInfo, allPeopleNameDate, childrenNameDate);

            } else if (stringStringPair.getValue().equals(personOfInterestNameDate.getKey()) // right side of pair = value = Child
                    || stringStringPair.getValue().equals(personOfInterestNameDate.getValue())) {

                String parentInfo = stringStringPair.getKey();
                findAndPut(parentInfo, allPeopleNameDate, parentsNameDate);
            }
        }

        System.out.println(personOfInterestNameDate.getKey() + " " + personOfInterestNameDate.getValue());

        System.out.println("Parents:");
        parentsNameDate.entrySet().stream()
                .forEach(p -> {
                    System.out.printf("%s %s%n", p.getKey(), p.getValue());
                });

        System.out.println("Children:");
        childrenNameDate.entrySet().stream()
                .forEach(c -> {
                    System.out.printf("%s %s%n", c.getKey(), c.getValue());
                });

        //main ends here
    }

    static void findAndPut(String info, Map<String, String> findFrom, Map<String, String> putIn) { //trying to couple the persons piece of info with the other
        for (Map.Entry<String, String> currentNameDate : findFrom.entrySet()) {                   //and add both pieces onto a map
            if (currentNameDate.getKey().equals(info) || currentNameDate.getValue().equals(info)) {
                putIn.put(currentNameDate.getKey(), currentNameDate.getValue());
                findFrom.remove(currentNameDate.getKey());
                break;
            }
        }
    }

}
