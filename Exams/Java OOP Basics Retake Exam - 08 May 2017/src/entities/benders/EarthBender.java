package entities.benders;

import abstract_classes.BaseBender;

public class EarthBender extends BaseBender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double calculatePower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                super.getName(), super.getPower(), this.groundSaturation);
    }
}
