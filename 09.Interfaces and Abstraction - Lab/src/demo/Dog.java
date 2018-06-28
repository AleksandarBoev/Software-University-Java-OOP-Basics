package demo;

public class Dog implements Animal {
    int wat = 25;

    @Override
    public String getSpecies() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Bau";
    }
}
