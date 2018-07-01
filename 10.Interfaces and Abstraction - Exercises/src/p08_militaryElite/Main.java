package p08_militaryElite;

import p08_militaryElite.classes.*;
import p08_militaryElite.exceptions.InvalidCorpsException;
import p08_militaryElite.exceptions.InvalidStateException;
import p08_militaryElite.interfaces.ISoldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //inputs will be in these formats:
        //Private: “Private <id> <firstName> <lastName> <salary>”
        //LeutenantGeneral: “LeutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id> … <privateNId>” where privateXId will always be an Id of a private already received through the input. --> private private or private and its extended stuff?
        //Engineer: “Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> … <repairNPart> <repairNHours>” where repairXPart is the name of a repaired part and repairXHours the hours it took to repair it (the two parameters will always come paired).
        //Commando: “Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> … <missionNCodeName> <missionNstate>” a missions code name, description and state will always come together.
        //Spy: “Spy <id> <firstName> <lastName> <codeNumber>”
        List<ISoldier> soldiers = new ArrayList<>();
        Map<String, Private> idPrivate = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String rank = tokens[0];
            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];
            boolean invalidCorpsExceptionCaught = false;

            //TODO is this a case in which I should use a factory pattern to create the different objects?
            ISoldier soldier = null;
            switch (rank) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    soldier = new Private(id, firstName, lastName, salary);
                    idPrivate.put(id, new Private(id, firstName, lastName, salary)); //not done very well...
                    break;

                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    Set<Private> privates = new HashSet<>();
                    for (int i = 5; i < tokens.length; i++) {
                        privates.add(idPrivate.get(tokens[i]));
                    }

                    soldier = new LeutenantGeneral(id, firstName, lastName, salary, privates);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    Set<Repair> repairsSet = new LinkedHashSet<>();

                    for (int i = 6; i < tokens.length; i+=2) {
                        String partName = tokens[i];
                        int hoursWorked = Integer.parseInt(tokens[i + 1]);
                        Repair currentRepair = new Repair(partName, hoursWorked);

                        repairsSet.add(currentRepair);
                    }

                    try {
                        soldier = new Engineer(id, firstName, lastName, salary, corps, repairsSet);
                    } catch (InvalidCorpsException ice) {
                        invalidCorpsExceptionCaught = true;
                    }
                    break;
//Commando: “Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> … <missionNCodeName>
// <missionNstate>” a missions code name, description and state will always come together.
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];
                    Set<Mission> missions = new LinkedHashSet<>();

                    for (int i = 6; i < tokens.length; i+=2) {
                        String missionCodeName = tokens[i];
                        String missionState = tokens[i + 1];
                        try {
                            Mission mission = new Mission(missionCodeName, missionState);
                            missions.add(mission);
                        } catch (InvalidStateException ise) {
                            continue;
                        }
                    }
                    try {
                        soldier = new Commando(id, firstName, lastName, salary, corps, missions);
                    } catch (InvalidCorpsException ice) {
                        invalidCorpsExceptionCaught = true;
                    }
                    break;

                case "Spy":
                    String codeNumber = tokens[4];
                    soldier = new Spy(id, firstName, lastName, codeNumber);
                    break;
            }

            if (invalidCorpsExceptionCaught) {
                continue; // don't add this soldier to the set, a.k.a. skip this line
            }

            soldiers.add(soldier);
        }
        reader.close();

        for (ISoldier soldier : soldiers) {
            System.out.println(soldier);
        }
        //main ends here
    }
}
