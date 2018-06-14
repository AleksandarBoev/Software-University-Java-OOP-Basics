package P06RawData;

public class Car {
    private String model;
    private Cargo cargo;
    private Engine engine;
    private Tires tires;

    public Car(String model, Integer engineSpeed, Integer enginePower, Integer cargoWeight, String cargoType,
               Double tire1Pressure, Integer tire1Age, Double tire2Pressure, Integer tire2Age,
               Double tire3Pressure, Integer tire3Age, Double tire4Pressure, Integer tire4Age) {
        this.model = model;
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Engine engine = new Engine(engineSpeed, enginePower);
        Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

        this.cargo = cargo;
        this.engine = engine;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    public boolean atLeastOneTireWithLowerPressure(double pressure) {
        return this.tires.getTire1Pressure() < pressure || this.tires.getTire2Pressure() < pressure || this.tires.getTire3Pressure() < pressure
                || this.tires.getTire4Pressure() < pressure;
    }

    public Integer getEnginePower() {
        return this.engine.getPower();
    }
}
