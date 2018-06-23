package p02_vehicleExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected static final String NEGATIVE_FUEL_MESSAGE = "Fuel must be a positive number";
    protected static final String FUEL_EXCEEDING_TANK_CAPACITY_MESSAGE = "Cannot fit fuel in tank";

    private double fuel;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    public Vehicle(double fuel, double fuelConsumptionPerKm, double tankCapacity) { //is there any reason to use abstract constructors?
        setFuel(fuel);
        setFuelConsumptionPerKm(fuelConsumptionPerKm);
        setTankCapacity(tankCapacity);
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

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected abstract String getVehicleType();


    protected abstract double getAdditionalFuelConsumptionFromAirConditioner(); //abstract because it will need different implementation in every child class

    protected boolean canRefuel(double amount) {
        return this.getFuel() + amount <= this.getTankCapacity();
    }

    public void refuel(double amount) {
        if (!this.canRefuel(amount)) {
            throw new IllegalArgumentException(FUEL_EXCEEDING_TANK_CAPACITY_MESSAGE);
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(NEGATIVE_FUEL_MESSAGE);
        }

        this.setFuel(this.getFuel() + amount);
    }

    public boolean travel(double distance) {
        double totalFuelNeededForTravel = this.getFuelConsumptionPerKm() * distance;

        if (totalFuelNeededForTravel > this.getFuel()) {
            return false;
        } else {
            setFuel(this.getFuel() - totalFuelNeededForTravel);
            return true;
        }
    }

    public String getTravelResult(double distance) {
        boolean hasTraveled = this.travel(distance);

        if (hasTraveled) {
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("%s travelled %s km", this.getVehicleType(), df.format(distance));
        } else {
            return String.format("%s needs refueling", this.getVehicleType());
        }
    }

    public boolean travelWithAirConditionerOn(double distance) { //not abstract, because the calculations are the same for the child classes (for this particular task)
        double actualFuelPerKm = (this.getFuelConsumptionPerKm() + this.getAdditionalFuelConsumptionFromAirConditioner());
        double totalFuelNeededForTravel = actualFuelPerKm * distance;

        if (totalFuelNeededForTravel > this.getFuel()) {
            return false;
        } else {
            setFuel(this.getFuel() - totalFuelNeededForTravel);
            return true;
        }
    }

    public String getTravelResultWithAirConditionerOn(double distance) {
        boolean hasTraveled = this.travelWithAirConditionerOn(distance);

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
