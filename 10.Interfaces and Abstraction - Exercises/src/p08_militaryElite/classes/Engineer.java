package p08_militaryElite.classes;

import javafx.util.Pair;
import p08_militaryElite.abstractClasses.SpecialisedSoldier;

import java.util.Set;

public class Engineer extends SpecialisedSoldier {
    private Set<Repair> repairsSet;

    public Engineer(String id, String firstName, String secondName, double salary, String corps, Set<Repair> repairSet) {
        super(id, firstName, secondName, salary, corps);
        this.repairsSet = repairSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Repairs:");
        if (this.repairsSet.isEmpty()) {
            return sb.toString();
        } else {
            sb.append(System.lineSeparator());
        }

        for (Repair repair : repairsSet) {
            sb.append("  ").append(repair.toString()).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length()); // deleting last new line

        return sb.toString();
    }
}
