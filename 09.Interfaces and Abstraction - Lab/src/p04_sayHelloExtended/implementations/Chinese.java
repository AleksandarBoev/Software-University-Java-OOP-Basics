package p04_sayHelloExtended.implementations;


import p04_sayHelloExtended.interfaces.Person;

public class Chinese extends BasePerson implements Person {

    public Chinese(String name) {
        super(name);
    }

//    @Override
//    protected void setName(String name) {
//        //validations for a chinese name
//        this.name = name;
//    }

    @Override
    public String sayHello() {
        return "Ni hao!";
    }
}
