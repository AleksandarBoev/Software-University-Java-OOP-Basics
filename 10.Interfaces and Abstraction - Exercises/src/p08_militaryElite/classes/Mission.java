package p08_militaryElite.classes;

import p08_militaryElite.constants.Constants;
import p08_militaryElite.exceptions.InvalidStateException;

import java.util.Set;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(String state) {
        if (Constants.MISSION_STATES.contains(state)) {
            this.state = state;
        } else {
            throw new InvalidStateException();
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
