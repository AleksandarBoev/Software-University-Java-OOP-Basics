package p03_wildFarm.animal_package;

import java.util.Set;

public class Zebra extends Mammal{
    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public String getAnimalTypePlural() {
        return "Zebras";
    }

    @Override
    protected void setAnimalType() {
        this.animalType = "Zebra";
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void setTypesOfFoodItEeats() {
        this.typesOfFoodItEeats = Set.of("Vegetable");
    }
}
