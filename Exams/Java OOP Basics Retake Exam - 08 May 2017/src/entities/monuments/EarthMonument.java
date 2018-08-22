package entities.monuments;

import abstract_classes.BaseMonument;

public class EarthMonument extends BaseMonument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public int getAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Earth", super.getName(), this.earthAffinity);
    }
}
