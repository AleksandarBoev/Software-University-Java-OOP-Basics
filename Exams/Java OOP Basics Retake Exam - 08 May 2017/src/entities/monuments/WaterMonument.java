package entities.monuments;

import abstract_classes.BaseMonument;

public class WaterMonument extends BaseMonument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public int getAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Water", super.getName(), this.waterAffinity);
    }
}
