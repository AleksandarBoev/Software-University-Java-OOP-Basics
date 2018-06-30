package p04_sayHelloExtended;

import p04_sayHelloExtended.implementations.Bulgarian;
import p04_sayHelloExtended.implementations.Chinese;
import p04_sayHelloExtended.implementations.European;
import p04_sayHelloExtended.interfaces.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { // TODO 50/100, task is badly described
        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Pesho"));
        people.add(new European("Pesho"));
        people.add(new Chinese("Pesho"));

        for (Person person : people) {
            System.out.println(person.sayHello());
        }
    }
}
