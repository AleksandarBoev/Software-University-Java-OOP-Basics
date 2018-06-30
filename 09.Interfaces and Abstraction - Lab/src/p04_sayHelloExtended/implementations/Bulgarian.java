package p04_sayHelloExtended.implementations;


import p04_sayHelloExtended.interfaces.Person;

public class Bulgarian extends BasePerson implements Person {
    public Bulgarian(String name) {
        super(name);
    }

//    @Override
//    protected void setName(String name) {
//        //validations for a bulgarian name
//        this.name = name;
//    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
