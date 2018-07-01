package p08_militaryElite.classes;

import p08_militaryElite.abstractClasses.Soldier;
import p08_militaryElite.interfaces.IPrivate;
import p08_militaryElite.interfaces.ISoldier;

public class Private extends Soldier implements IPrivate, ISoldier {
    private double salary;

    public Private(String id, String firstName, String secondName, double salary) {
        super(id, firstName, secondName);
        this.salary = salary;
    }


    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id> Salary: <salary>
        return String.format("Name: %s %s Id: %s Salary: %.2f", this.getFirstName(), this.getSecondName(),
                this.getId(), this.getSalary());
    }
}
