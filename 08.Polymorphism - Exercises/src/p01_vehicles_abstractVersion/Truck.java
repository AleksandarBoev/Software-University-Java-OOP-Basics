package p01_vehicles_abstractVersion;

public class Truck extends Vehicle {
    public Truck(double fuel, double fuelConsumptionPerKm) {
        super(fuel, fuelConsumptionPerKm);
    }

    @Override
    protected String getVehicleType() {
        return "Truck";
    }

    @Override
    protected double getAdditionalFuelConsumptionDuringSummer() {
        return 1.6;
    }

    @Override
    public void refuel(double amount) {
        this.setFuel(this.getFuel() + amount * 0.95);
    }


}
