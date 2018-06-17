package p04_firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPeople = Integer.parseInt(reader.readLine());
        Team team = new Team();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = reader.readLine().split(" ");
            try {
                Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                team.addPerson(person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }

        System.out.println(team.displayFirstTeamInfo());
        System.out.println(team.displayReserveTeamInfo());

        //main ends here
    }
}
