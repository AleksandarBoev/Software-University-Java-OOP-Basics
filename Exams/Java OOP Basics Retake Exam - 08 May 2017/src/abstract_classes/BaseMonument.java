package abstract_classes;

import contracts.Monument;

public abstract class BaseMonument implements Monument { //TODO additional properties are of the same kind. Maybe add them here?
    private String name;

    protected BaseMonument(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "###%1$s Monument: %2$s, %1$s Affinity: %3$d";
    }
}
