package p04_sayHelloExtended.implementations;

import p04_sayHelloExtended.interfaces.Person;

public abstract class BasePerson implements Person {
    protected String name;

    public BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
