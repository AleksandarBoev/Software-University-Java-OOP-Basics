package p08_militaryElite.abstractClasses;

import p08_militaryElite.interfaces.ISoldier;

public abstract class Soldier implements ISoldier {
    private String id;
    private String firstName;
    private String secondName;

    public Soldier(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getSecondName() {
        return this.secondName;
    }

    public abstract String toString();
}
