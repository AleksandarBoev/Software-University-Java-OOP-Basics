package p04_mordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Gandalf gandalf = new Gandalf();

        Arrays.stream(reader.readLine().split(" "))
                .forEach(food -> {
                    gandalf.eatFood(food);
                });

        System.out.println(gandalf.getHappyPoints());
        System.out.println(gandalf.getMood());
        //main ends here
    }
}
