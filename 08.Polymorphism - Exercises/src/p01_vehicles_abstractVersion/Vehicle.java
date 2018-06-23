package p01_vehicles_abstractVersion;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private double fuelConsumptionPerKm;

    public Vehicle(double fuel, double fuelConsumptionPerKm) { //is there any reason to use abstract constructors?
        setFuel(fuel);
        setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    protected double getFuel() {
        return this.fuel;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    private void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected abstract String getVehicleType();


    protected abstract double getAdditionalFuelConsumptionDuringSummer(); //abstract because it will need different implementation in every child class

    public abstract void refuel(double amount);

    public boolean travelDuringSummer(double distance) { //not abstract, because the calculations are the same for the child classes (for this particular task)
        double actualFuelPerKm = (this.getFuelConsumptionPerKm() + this.getAdditionalFuelConsumptionDuringSummer());
        double totalFuelNeededForTravel = actualFuelPerKm * distance;

        if (totalFuelNeededForTravel > this.getFuel()) {
            return false;
        } else {
            setFuel(this.getFuel() - totalFuelNeededForTravel);
            return true;
        }
    }

    public String getTravelResult(double distance) {
        boolean hasTraveled = this.travelDuringSummer(distance);

        if (hasTraveled) {
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("%s travelled %s km", this.getVehicleType(), df.format(distance));
        } else {
            return String.format("%s needs refueling", this.getVehicleType());
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getVehicleType(), this.getFuel());
    }
}
