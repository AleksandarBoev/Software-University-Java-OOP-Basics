package entities.monuments;

import abstract_classes.BaseMonument;

public class FireMonument extends BaseMonument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Fire", super.getName(), this.fireAffinity);
    }
}
