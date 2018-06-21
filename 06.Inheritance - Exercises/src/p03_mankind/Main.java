package p03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentTokens = reader.readLine().split(" ");
        String[] workerTokens = reader.readLine().split(" ");

        Human student = null;
        Human worker = null;
        try {
            student = new Student(studentTokens[0], studentTokens[1], studentTokens[2]);
            worker = new Worker(workerTokens[0], workerTokens[1], Double.parseDouble(workerTokens[2]), Integer.parseInt(workerTokens[3]));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        List<Human> humans = new ArrayList<>();
        humans.add(student);
        humans.add(worker);

        for (Human human : humans) {
            System.out.println(human);
        }

        //main ends here
    }
}
