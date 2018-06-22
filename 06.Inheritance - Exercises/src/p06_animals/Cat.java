package p06_animals;

public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String getSpecies() {
        return "Cat";
    }

    @Override
    protected String produceSound() {
        return "MiauMiau";
    }
}
