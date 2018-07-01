package p08_militaryElite.classes;

import p08_militaryElite.abstractClasses.Soldier;

public class Spy extends Soldier {
    private String codeNumber;

    public Spy(String id, String firstName, String secondName, String codeNumber) {
        super(id, firstName, secondName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id>
        //Code Number: <codeNumber>
        return String.format("Name: %s %s Id: %s%nCode Number: %s", this.getFirstName(), this.getSecondName(),
                this.getId(), this.codeNumber);
    }
}
