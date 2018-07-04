package classes;

import abstractClasses.Car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    //Has addOns (Collection of strings). (by default – empty)
    //Increases its given horsepower by 50%.
    //Decreases its given suspension by 25%.
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    //Note: 50% of X is EQUAL to (X * 50) / 100.
//Note: Decrease means DECREASE… 100 decreased by 25% = 100 – (100 * 25) / 100 = 100 – 25 = 75.
    @Override
    protected void setHorsepower(int horsePower) {
        int result = this.getHorsepower() + (this.getHorsepower() * 50) / 100;
        super.setHorsepower(result);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - ((suspension * 25) / 100));
    }

    private List<String> getAddOns() {
        return this.addOns;
    }

    @Override
    public void tuneCar(int tuneIndex, String tuneAddOn) {
        int additionalHorsePower = tuneIndex;
        int additionalSuspension = tuneIndex / 2;

        this.setHorsepower(this.getHorsepower() + additionalHorsePower);
        this.setSuspension(this.getSuspension() + additionalSuspension);
        this.getAddOns().add(tuneAddOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(super.toString());
        sb.append("Add-ons: ");

        if (this.getAddOns().isEmpty()) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.getAddOns()));
        }

        return sb.toString();
    }
}
