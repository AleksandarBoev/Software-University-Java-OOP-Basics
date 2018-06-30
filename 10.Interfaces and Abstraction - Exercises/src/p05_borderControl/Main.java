package p05_borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //test input:
        //Pesho 22 9010101122
        //MK-13 558833251
        //MK-12 33283122
        //End
        //122
        List<CheckIdInterface> robotsAndCitizensToBeChecked = new ArrayList<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            CheckIdInterface citizenOrRobot = null;

            if (tokens.length == 3) {
                citizenOrRobot = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                citizenOrRobot = new Robot(tokens[0], tokens[1]);
            }

            robotsAndCitizensToBeChecked.add(citizenOrRobot);
        }
        String fakeIdIndicator = reader.readLine();
        reader.close();

        for (CheckIdInterface robotOfCitizen : robotsAndCitizensToBeChecked) {
            if (robotOfCitizen.idIsFake(fakeIdIndicator)) {
                System.out.println(robotOfCitizen.getId());
            }
        }
    }
}
