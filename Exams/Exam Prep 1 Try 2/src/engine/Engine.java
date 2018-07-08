package engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private HealthManager healthManager;

    public Engine() {
        this.healthManager = new HealthManager();
    }

    private HealthManager getHealthManager() {
        return this.healthManager;
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while(!"BEER IS COMING".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command) {
                case "checkCondition":
                    System.out.print(getHealthManager().checkCondition(tokens[1]));
                    break;

                case "createOrganism":
                    System.out.print(getHealthManager().createOrganism(tokens[1]));
                    break;

                case "addCluster":
                    System.out.print(getHealthManager().addCluster(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                    break;

                case "addCell":
                    System.out.print(getHealthManager().addCell(tokens[1], tokens[2], tokens[3], tokens[4],
                            Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8])));
                    break;

                case "activateCluster":
                    System.out.print(getHealthManager().activateCluster(tokens[1]));
                    break;
            }
        }
        reader.close();
    }
}
