package entities.monuments;

import abstract_classes.BaseMonument;

public class AirMonument extends BaseMonument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public int getAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Air", super.getName(), this.airAffinity);

    }
}
