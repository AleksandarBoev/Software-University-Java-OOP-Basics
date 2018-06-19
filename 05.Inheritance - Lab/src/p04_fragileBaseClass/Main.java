package p04_fragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator(); //TODO this works? I thought constructors can't be inherited!? Maybe because they are in the same package?

        Food[] food = new Food[]{new Food(), new Food(), new Food()};
        predator.eatAll(food); //TODO health is being increased?! The subclass method eat is being used instead the base class one in the baseclass method?!
    }
}
