package p03_sayHello.implementations;

import p03_sayHello.interfaces.Person;

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.setName(name);
    }

    protected void setName(String name) {
        //validations for a chinese name
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Ni hao!";
    }
}
