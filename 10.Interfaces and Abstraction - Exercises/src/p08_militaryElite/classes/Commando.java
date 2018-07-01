package p08_militaryElite.classes;

import p08_militaryElite.abstractClasses.SpecialisedSoldier;
import p08_militaryElite.interfaces.IPrivate;

import java.util.Set;

public class Commando extends SpecialisedSoldier implements IPrivate {
    private Set<Mission> missions;

    public Commando(String id, String firstName, String secondName, double salary, String corps, Set<Mission> missions) {
        super(id, firstName, secondName, salary, corps);
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("Missions:");
        if (this.missions.isEmpty()) {
            return sb.toString();
        } else {
            sb.append(System.lineSeparator());
        }

        for (Mission mission : missions) {
            sb.append("  ").append(mission.toString()).append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
}
