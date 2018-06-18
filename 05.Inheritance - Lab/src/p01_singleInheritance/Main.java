package p01_singleInheritance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Name please: ");
        String name = reader.readLine();
        System.out.print("Age pls: ");
        int age = Integer.parseInt(reader.readLine());

        try {
            Student student = new Student(name, age);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }


        //main ends here
    }
}
