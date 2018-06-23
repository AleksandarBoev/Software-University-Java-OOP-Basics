package p02_vehicleExtension;

public class Car extends Vehicle {

    public Car(double fuel, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuel, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected String getVehicleType() {
        return "Car";
    }

    @Override
    protected double getAdditionalFuelConsumptionFromAirConditioner() {
        return 0.9;
    }

}
