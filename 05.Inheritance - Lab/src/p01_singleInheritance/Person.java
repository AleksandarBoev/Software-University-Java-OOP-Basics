package p01_singleInheritance;

public class Person {
    protected String name;
    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if ("Pesho".equals(name)) {
            throw new IllegalArgumentException("Pick an original name!");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Not possible!");

        }

        this.age = age;
    }


}
