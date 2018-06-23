package p03_wildFarm.animal_package;

import java.text.DecimalFormat;
import java.util.Set;

public class Cat extends Feline {
    private String catBreed;

    public Cat(String animalName, double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalWeight, livingRegion);
        this.catBreed = catBreed;
    }

    @Override
    public String getAnimalTypePlural() {
        return "Cats";
    }

    @Override
    protected void setAnimalType() {
        this.animalType = "Cat";
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void setTypesOfFoodItEeats() {
        this.typesOfFoodItEeats = Set.of("Vegetable", "Meat");
    }

//    @Override
//    public void eatFood(Food food) {
//        this.foodEaten += food.getQuantity();
//    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.####################");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), this.catBreed, df.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
