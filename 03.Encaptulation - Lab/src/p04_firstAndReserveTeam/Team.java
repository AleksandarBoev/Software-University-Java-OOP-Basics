package p04_firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team() {
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    public void addPerson(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    public String displayFirstTeamInfo() {
        return String.format("First team have %d players", this.firstTeam.size());
    }

    public String displayReserveTeamInfo() {
        return String.format("Reserve team have %d players", this.reserveTeam.size());
    }
}
