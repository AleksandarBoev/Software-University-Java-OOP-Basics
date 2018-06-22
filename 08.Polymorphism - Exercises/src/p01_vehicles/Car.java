package p01_vehicles;

import java.text.DecimalFormat;

public class Car {
    //Car and truck both have fuel quantity, fuel consumption in liters per km and can be
    // driven given distance and refueled with given liters.
    protected static final DecimalFormat df = new DecimalFormat("#.##");
    private double fuel;
    private double fuelConsumptionLitersPerKm;

    public Car(double fuel, double fuelConsumptionLitersPerKm) {
        this.fuel = fuel;
        this.fuelConsumptionLitersPerKm = fuelConsumptionLitersPerKm;
    }

    protected double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected double getFuelConsumptionLitersPerKm() {
        return this.fuelConsumptionLitersPerKm;
    }

    public void setFuelConsumptionLitersPerKm(double fuelConsumptionLitersPerKm) {
        this.fuelConsumptionLitersPerKm = fuelConsumptionLitersPerKm;
    }

    protected String getVehicleType() {
        return "Car";
    }

    protected double getAdditionalConsumptionPerKmDuringSummer() {
        return 0.9;
    }

    public void refuel(double refuelAmount) {
        this.fuel += refuelAmount; //is fuel the initial fuel or the max quantity?
    }

    public void travel(double distanceInKm) {
        double travelFuelConsumption = distanceInKm
                * (this.getAdditionalConsumptionPerKmDuringSummer() + this.getFuelConsumptionLitersPerKm());

        if (travelFuelConsumption <= this.fuel) {
            System.out.println(String.format("%s travelled %s km", this.getVehicleType(), df.format(distanceInKm)));
            this.setFuel(this.fuel - travelFuelConsumption);
        } else {
            System.out.println(String.format("%s needs refueling", this.getVehicleType()));
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getVehicleType(), this.getFuel());
    }
}
