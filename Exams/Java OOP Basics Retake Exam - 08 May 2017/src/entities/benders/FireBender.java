package entities.benders;

import abstract_classes.BaseBender;

public class FireBender extends BaseBender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double calculatePower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                super.getName(), super.getPower(), this.heatAggression);
    }
}
