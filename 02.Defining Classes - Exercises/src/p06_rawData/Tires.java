package p06_rawData;

public class Tires {
    private Double tire1Pressure; // could be done with an array of Pair<Double, Integer>
    private Integer tire1Age;

    private Double tire2Pressure;
    private Integer tire2Age;

    private Double tire3Pressure;
    private Integer tire3Age;

    private Double tire4Pressure;
    private Integer tire4Age;

    public Tires(Double tire1Pressure, Integer tire1Age, Double tire2Pressure, Integer tire2Age, Double tire3Pressure, Integer tire3Age, Double tire4Pressure, Integer tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public Double getTire1Pressure() {
        return this.tire1Pressure;
    }

    public Double getTire2Pressure() {
        return this.tire2Pressure;
    }

    public Double getTire3Pressure() {
        return this.tire3Pressure;
    }

    public Double getTire4Pressure() {
        return this.tire4Pressure;
    }
}
