package p06_birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Citizen Pesho 22 9010101122 10/10/1990
        //Pet Sharo 13/11/2005
        //Robot MK-13 558833251
        //End
        //1990

        List<CheckBirthDateInterface> petsAndCitizensToBeChecked = new ArrayList<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Citizen":
                    petsAndCitizensToBeChecked.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;

                case "Pet":
                    petsAndCitizensToBeChecked.add(new Pet(tokens[1], tokens[2]));
                    break;
            }
        }
        String yearToCheck = reader.readLine();
        reader.close();

        for (CheckBirthDateInterface petOtCitizen : petsAndCitizensToBeChecked) {
            if (petOtCitizen.isBornThisYear(yearToCheck)) {
                System.out.println(petOtCitizen.getBirthDate());
            }
        }
    }
}
