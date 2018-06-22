package p06_animals;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String getSpecies() {
        return "Dog";
    }

    @Override
    protected String produceSound() {
        return "BauBau";
    }
}
