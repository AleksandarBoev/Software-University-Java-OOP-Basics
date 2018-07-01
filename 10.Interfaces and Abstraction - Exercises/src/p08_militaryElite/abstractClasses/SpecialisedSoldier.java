package p08_militaryElite.abstractClasses;

import p08_militaryElite.classes.Private;
import p08_militaryElite.constants.Constants;
import p08_militaryElite.exceptions.InvalidCorpsException;

import java.util.Set;

public abstract class SpecialisedSoldier extends Private {
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String secondName, double salary, String corps) {
        super(id, firstName, secondName, salary);
        setCorps(corps);
    }

    private void setCorps(String corps) {
        if (Constants.VALID_CORPS.contains(corps)) {
            this.corps = corps;
        } else {
            throw new InvalidCorpsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.corps);

        return sb.toString();
    }
}
