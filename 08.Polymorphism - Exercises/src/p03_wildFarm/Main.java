package p03_wildFarm;

import p03_wildFarm.animal_package.*;
import p03_wildFarm.food_package.Food;
import p03_wildFarm.food_package.Meat;
import p03_wildFarm.food_package.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main { // TODO test1 doesn't pass. No idea why. Try finding the mistake by checking out this solution: https://github.com/AtanasYordanov/Java-Advanced/tree/master/Java%20OOP%20Basics/t04_Polymorphism/p03_WildFarm
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] animalTokens = input.split(" ");
            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            double animalWeight = Double.parseDouble(animalTokens[2]);
            String animalLivingRegion = animalTokens[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String catBreed = animalTokens[4];
                    animal = new Cat(animalName, animalWeight, animalLivingRegion, catBreed);
                    break;

                case "Tiger":
                    animal = new Tiger(animalName, animalWeight, animalLivingRegion);
                    break;

                case "Mouse":
                    animal = new Mouse(animalName, animalWeight, animalLivingRegion);
                    break;

                case "Zebra":
                    animal = new Zebra(animalName, animalWeight, animalLivingRegion);
                    break;
            }
            animals.add(animal);

            animal.makeSound();

            String[] foodTokens = reader.readLine().split(" ");
            String foodType = foodTokens[0];
            int quantity = Integer.parseInt(foodTokens[1]);

            Food food = null;
            if ("Meat".equalsIgnoreCase(foodType)) {
                food = new Meat(quantity);
            } else {
                food = new Vegetable(quantity);
            }

            try {
                animal.eatFood(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }
        reader.close();

        for (Animal animal1 : animals) {
            System.out.println(animal1);
        }

        //main ends here
    }
}
