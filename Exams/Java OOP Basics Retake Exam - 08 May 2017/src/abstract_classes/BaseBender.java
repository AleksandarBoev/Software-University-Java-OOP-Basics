package abstract_classes;

import contracts.Bender;

public abstract class BaseBender implements Bender { //TODO maybe the name should be different
    private String name;
    private int power;

    protected BaseBender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    protected String getName() {
        return this.name;
    }

    protected int getPower() {
        return this.power;
    }
}
