package p03_ferrari;

public class Ferrari implements Car {
    private static final String CAR_MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!"; // ...
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", CAR_MODEL, this.brakes(), this.gasPedal(), this.driverName);
    }
}
