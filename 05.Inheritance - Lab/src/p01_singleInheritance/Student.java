package p01_singleInheritance;

public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public String getName() {
        return this.name;
    }
}
