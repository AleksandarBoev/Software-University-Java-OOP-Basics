package p01_vehicles;

public class Truck extends Car {
    public Truck(double initialFuel, double fuelConsumptionLitersPerKm){
        super(initialFuel, fuelConsumptionLitersPerKm);
    }

    @Override
    protected double getAdditionalConsumptionPerKmDuringSummer() {
        return 1.6;
    }

    @Override
    public void refuel(double amount) {
        setFuel(this.getFuel() + amount * 0.95);
    }

    @Override
    protected String getVehicleType() {
        return "Truck";
    }
}
