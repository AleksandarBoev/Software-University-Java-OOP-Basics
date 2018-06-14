package P05SpeedRacing;

import java.text.DecimalFormat;

public class Car {
    private String model; // could be used as a key
    private Double fuelAmount;
    private Double fuelCostPerKilometer;
    private Double distanceTraveled;

    public Car(String model, Double fuelAmount, Double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTraveled = 0.0;
    }

    public void reduceFuelAmount(Double fuelAmount) {
        this.fuelAmount -= fuelAmount;
    }

    public void increaseDistanceTraveled(Double distanceTraveled) {
        this.distanceTraveled += distanceTraveled;
    }

    public boolean canTravelDistance(Double distance) {
        Double fuelAmountNeeded = distance * this.fuelCostPerKilometer;

        if (fuelAmountNeeded > this.fuelAmount) {
            return false;
        } else {
            increaseDistanceTraveled(distance);
            reduceFuelAmount(fuelAmountNeeded);
            return true;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#############");
        return String.format("%s %.2f %s", this.model, this.fuelAmount, df.format(this.distanceTraveled));
    }
}
