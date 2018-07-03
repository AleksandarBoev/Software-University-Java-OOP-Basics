import classes.Organism;
import engine.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //my test input:

        //createOrganism Troli
        //createOrganism Troli
        //addCluster Trr X05 2 3
        //addCell Trr X05 WhiteBloodCell WBC 5 0 0 5
        //checkCondition Troli
        //addCluster Troli X05 2 3
        //addCell Troli X05 WhiteBloodCell WBC 5 0 0 5
        //checkCondition Troli
        //BEER IS COMING

        HealthManager healthManager = new HealthManager();

        String input;
        while(!"BEER IS COMING".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "createOrganism":
                    System.out.println(healthManager.createOrganism(tokens[1]));
                    break;

                case "addCluster":
                    System.out.println(healthManager.addCluster(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                    break;

                case "addCell":
                    System.out.println(healthManager.addCell(tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8])));
                    break;

                case "activateCluster":
                    System.out.println(healthManager.activateCluster(tokens[1]));
                    break;

                case "checkCondition":
                    System.out.println(healthManager.checkCondition(tokens[1]));
                    break;
            }
        }


        reader.close();
    }
}
