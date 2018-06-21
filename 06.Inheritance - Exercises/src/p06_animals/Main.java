package p06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main { // TODO 83/100 last test giving trouble (not a runtime error)
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Animal> animals = new LinkedHashSet<>();

        String input;
        while (!"Beast!".equals(input = reader.readLine())) {
            String species = input;

            String[] tokens = reader.readLine().split(" ");
            if (tokens.length != 3 || "".equals(tokens[0]) || "".equals(tokens[1]) || "".equals(tokens[2])) {
                throw new IllegalArgumentException(Animal.INVALID_INPUT_MESSAGE);
            }

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                if (!Animal.ALLOWED_SPECIES.contains(species.toLowerCase())) {
                    throw new IllegalArgumentException(Animal.getInvalidInputMessage());
                }

                Animal currentAnimal = null;

                switch (species.toLowerCase()) {
                    case "dog":
                        currentAnimal = new Dog(name, age, gender);
                        break;

                    case "cat":
                        currentAnimal = new Cat(name, age, gender);
                        break;

                    case "tomcat":
                        currentAnimal = new Tomcat(name, age, gender);
                        break;

                    case "kitten":
                        currentAnimal = new Kitten(name, age, gender);
                        break;

                    case "frog":
                        currentAnimal = new Frog(name, age, gender);
                        break;

                    case "animal":
                        currentAnimal = new Animal(name, age, gender);
                        break;

                    default:
                        break;
                }

                animals.add(currentAnimal);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        //main ends here
    }
}
