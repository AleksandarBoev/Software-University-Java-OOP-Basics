package p01_vehicles_abstractVersion;

public class Car extends Vehicle {

    public Car(double fuel, double fuelConsumptionPerKm) {
        super(fuel, fuelConsumptionPerKm);
    }

    @Override
    protected String getVehicleType() {
        return "Car";
    }

    @Override
    protected double getAdditionalFuelConsumptionDuringSummer() {
        return 0.9;
    }

    @Override
    public void refuel(double amount) {
        this.setFuel(this.getFuel() + amount);
    }
}
