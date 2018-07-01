package p07_foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        //2
        //Pesho 25 8904041303 04/04/1989
        //Stancho 27 WildMonkeys
        //Pesho
        //Gosho
        //Pesho
        //End
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, BuyerInterface> namePerson = new HashMap();

        int numberOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = reader.readLine().split(" ");

            String name = tokens[0];
            if (namePerson.containsKey(name))
                continue;

            BuyerInterface citizenOrRebel = null;
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 3) {
                citizenOrRebel = new Rebel(name, age, tokens[2]);
            } else {
                citizenOrRebel = new Citizen(name, age, tokens[2], tokens[3]);
            }

            namePerson.put(name, citizenOrRebel);
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            if (namePerson.containsKey(input)) {
                namePerson.get(input).buyFood();
            }
        }
        reader.close();

        int foodSum = namePerson.entrySet().stream()
                .mapToInt(p -> p.getValue().getFood())
                .sum();

        System.out.println(foodSum);
        //main ends here
    }
}
