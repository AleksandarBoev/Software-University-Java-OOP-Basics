package demo;

public class Cat implements Animal {

    @Override
    public String getSpecies() {
        return "Cat";
    }

    @Override
    public String makeSound() {
        return "Mew";
    }
}
