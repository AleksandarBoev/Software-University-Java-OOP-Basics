package p11_catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException { //first judge task on inheritance. Can probably be done better!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> nameCat = new HashMap<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens = null;
            try {
                tokens = input.split(" ");
            } catch (ArrayIndexOutOfBoundsException aiobe) {
                System.out.println("Not exact number of parameters!");
                continue;
            }

            Cat currentCat = null;
            String breed = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            try {
                Cat.evaluateBreed(breed);

            switch (breed) {
                case "StreetExtraordinaire":
                    currentCat = new StreetExtraordinaire(name, value);
                    break;

                case "Siamese":
                    currentCat = new SiameseCat(name, value);
                    break;

                case "Cymric":
                    currentCat = new CymricCat(name, value);
                    break;
            }

            nameCat.put(name, currentCat);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        String catToBeDesplayed = reader.readLine();

        System.out.println(nameCat.get(catToBeDesplayed));

        //main ends here
    }
}
