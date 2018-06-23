package p03_wildFarm.animal_package;

import p03_wildFarm.food_package.Food;

import java.util.Set;

public abstract class Animal {
    private static final String ANIMAL_CANT_EAT_THIS_FOOD_TYPE_MESSAGE = "%s are not eating that type of food!";

    private String animalName;
    protected String animalType; //wanted to make it an abstract method, because all inheriters will be different, and also static, but compiler doesn't allow it
    private double animalWeight;
    protected int foodEaten;
    protected Set<String> typesOfFoodItEeats;

    public Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        setAnimalType();
        setTypesOfFoodItEeats();
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public abstract String getAnimalTypePlural();

    protected double getAnimalWeight() {
        return this.animalWeight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    protected abstract void setAnimalType();

    public abstract void makeSound();

    protected abstract void setTypesOfFoodItEeats();

    public void eatFood(Food food) {
        if (this.typesOfFoodItEeats.contains(food.getFoodType())) {
            this.foodEaten += food.getQuantity();
        } else {
            throw new IllegalArgumentException(String.format(ANIMAL_CANT_EAT_THIS_FOOD_TYPE_MESSAGE, this.getAnimalTypePlural()));
        }
    }
}
