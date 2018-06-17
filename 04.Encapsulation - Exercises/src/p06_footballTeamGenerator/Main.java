package p06_footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Team;Arsenal
        //Add;Arsenal;Kieran_Gibbs;75;85;84;92;67
        //Add;Arsenal;Aaron_Ramsey;95;82;82;89;68
        //Remove;Arsenal;Aaron_Ramsey
        //Rating;Arsenal
        //END

        Map<String, Team> nameTeams = new HashMap<>();

        String input;
        while(!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");

            String command = tokens[0];

            try {
                if ("Team".equals(command)) {
                    Team currentTeam = new Team(tokens[1]);
                    nameTeams.put(currentTeam.getName(), currentTeam);
                } else if ("Add".equals(command)) {
                    String teamName = tokens[1];

                    if (!nameTeams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        continue;
                    }

                    String playerName = tokens[2];
                    Integer endurance = Integer.parseInt(tokens[3]);
                    Integer sprint = Integer.parseInt(tokens[4]);
                    Integer dribble = Integer.parseInt(tokens[5]);
                    Integer passing = Integer.parseInt(tokens[6]);
                    Integer shooting = Integer.parseInt(tokens[7]);

                    Player currentPlayer = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                    nameTeams.get(teamName).addPlayer(currentPlayer);
                } else if ("Remove".equals(command)) {
                    String teamName = tokens[1];
                    String playerName = tokens[2];

                    nameTeams.get(teamName).removePlayer(playerName);
                } else if ("Rating".equals(command)) {
                    String teamName = tokens[1];

                    if (!nameTeams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        continue;
                    }

                    System.out.println(nameTeams.get(teamName).getRating());
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        //main ends here
    }
}
