package p02_vehicleExtension;

public class Truck extends Vehicle {
    public Truck(double fuel, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuel, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected String getVehicleType() {
        return "Truck";
    }

    @Override
    protected double getAdditionalFuelConsumptionFromAirConditioner() {
        return 1.6;
    }

    @Override //should I see if the fuel is more than the tank capacity before or after the 5% loss? Seems to work this way
    public void refuel(double amount) {
        if (!this.canRefuel(amount)) {
            throw new IllegalArgumentException(FUEL_EXCEEDING_TANK_CAPACITY_MESSAGE);
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(NEGATIVE_FUEL_MESSAGE);
        }

        this.setFuel(this.getFuel() + amount * 0.95);
    }


}
