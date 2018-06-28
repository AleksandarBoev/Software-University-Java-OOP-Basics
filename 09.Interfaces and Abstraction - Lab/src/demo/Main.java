package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Animal cat = new Cat();
//        Animal dog = new Dog();
//
//        List<Animal> animals = new ArrayList<>();
//        animals.add(cat);
//        animals.add(dog);
//
//        for (Animal animal : animals) {
//            System.out.println(animal.getSpecies());
//            System.out.println(animal.makeSound());
//            System.out.println(Cat.wat);
//        }

        Tiger tiger = new Tiger();
        tiger.makeSound();

        //main ends here
    }
}
