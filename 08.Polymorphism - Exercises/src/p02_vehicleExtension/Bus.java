package p02_vehicleExtension;

public class Bus extends Vehicle {

    public Bus(double fuel, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuel, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected String getVehicleType() {
        return "Bus";
    }

    @Override
    protected double getAdditionalFuelConsumptionFromAirConditioner() {
        return 1.4;
    }

}
