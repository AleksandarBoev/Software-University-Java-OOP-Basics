package p03_sayHello.implementations;

import p03_sayHello.interfaces.Person;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.setName(name);
    }

    protected void setName(String name) {
        //validations for a bulgarian name
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
