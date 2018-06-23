package p03_wildFarm.animal_package;

import java.util.Set;

public class Mouse extends Mammal {
    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public String getAnimalTypePlural() {
        return "Mice";
    }

    @Override
    protected void setAnimalType() {
        animalType = "Mouse";
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void setTypesOfFoodItEeats() {
        this.typesOfFoodItEeats = Set.of("Vegetable");
    }
}
