package p03_wildFarm.animal_package;

import java.util.Set;

public class Tiger extends Feline {
    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public String getAnimalTypePlural() {
        return "Tigers";
    }

    @Override
    protected void setAnimalType() {
        this.animalType = "Tiger";
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void setTypesOfFoodItEeats() {
        this.typesOfFoodItEeats = Set.of("Meat");
    }
}
