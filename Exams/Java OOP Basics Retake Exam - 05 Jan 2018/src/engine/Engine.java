package engine;

import abstractClasses.Colonist;
import classes.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Engine {
    private static final String FAMILY_DOES_NOT_EXIST_MESSAGE = "family does not exist";

    Colony colony;

    public Engine() {

    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] colonyTokens = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        this.colony = new Colony(colonyTokens[0], colonyTokens[1]);

        String input;
        while (!"end".equals(input = reader.readLine().trim())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "insert":
                    //insert {class} {colonistId} {familyId} {talent} {age} {sign?}
                    String colonistClass = tokens[1];
                    String colonistId = tokens[2];
                    String familyId = tokens[3];
                    int talent = Integer.parseInt(tokens[4]);
                    int age = Integer.parseInt(tokens[5]);

                    Colonist currentColonist = null;
                    switch (colonistClass) {
                        case "Soldier":
                            currentColonist = new Soldier(colonistId, familyId, talent, age);
                            break;

                        case "SoftwareEngineer":
                            currentColonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                            break;

                        case "HardwareEngineer":
                            currentColonist = new HardwareEngineer(colonistId, familyId, talent, age);
                            break;

                        case "GeneralPractitioner":
                            String sign = tokens[6];
                            currentColonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign);
                            break;

                        case "Surgeon":
                            sign = tokens[6];
                            currentColonist = new Surgeon(colonistId, familyId, talent, age, sign);
                            break;
                    }
                    try {
                        this.colony.addColonist(currentColonist);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;

                case "remove":
                    //remove {modificator} {familyId} {colonistId?}
                    //remove colonist S2(familyId) Stefcho (colonistId)
                    //remove family S1
                    if ("colonist".equals(tokens[1])) {
                        familyId = tokens[2];
                        colonistId = tokens[3];
                        this.colony.removeColonist(familyId, colonistId);
                    } else {
                        familyId = tokens[2];
                        this.colony.removeFamily(familyId);
                    }
                    break;

                case "grow":
                    int years = Integer.parseInt(tokens[1]);
                    this.colony.grow(years);
                    break;

                case "potential":
                    System.out.println(String.format("potential: %d", this.colony.getPotential()));
                    break;

                case "capacity":
                    System.out.println(this.colony.getCapacity());
                    break;

                case "family":
                    //family S1
                    familyId = tokens[1];
                    //"family does not exist"
                    List<Colonist> currentColonists = this.colony.getColonistsByFamilyId(familyId); //why is this method needed?!
                    if (currentColonists == null) {
                        System.out.println(FAMILY_DOES_NOT_EXIST_MESSAGE);
                    } else {
                        Family currentFamily = this.colony.getIdFamily().get(familyId);
                        System.out.println(currentFamily.toString());
                    }
                    break;
            }
        }

        reader.close();
    }
}
