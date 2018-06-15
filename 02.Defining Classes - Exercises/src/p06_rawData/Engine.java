package p06_rawData;

public class Engine {
    private Integer speed;
    private Integer power;

    public Engine(Integer speed, Integer power) {
        this.speed = speed;
        this.power = power;
    }

    public Integer getPower() {
        return this.power;
    }
}
