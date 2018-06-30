package p03_sayHello.implementations;

import p03_sayHello.interfaces.Person;

public class European implements Person {
    private String name;

    public European(String name) {
        this.setName(name);
    }

    protected void setName(String name) {
        //validations for an european name
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
