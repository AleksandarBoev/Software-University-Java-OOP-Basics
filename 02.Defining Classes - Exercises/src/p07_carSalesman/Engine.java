package p07_carSalesman;

public class Engine {//model, power, displacement(o) and efficiency(o)
    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power) {
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Integer getPower() {
        return this.power;
    }

    public Integer getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
