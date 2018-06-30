package p04_sayHelloExtended.implementations;


import p04_sayHelloExtended.interfaces.Person;

public class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

//    @Override
//    protected void setName(String name) {
//        //validations for an european name
//        this.name = name;
//    }

}
