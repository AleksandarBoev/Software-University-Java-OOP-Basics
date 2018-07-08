package abstractClasses;

import classes.Power;
import constants.Constants;

import java.util.List;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.evilness = evilness;
    }

    private void setEvilness(double evilness) {
        if (evilness >= 0) {
            this.evilness = evilness;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_EVILNESS_MESSAGE);
        }
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    //•	###Evilness: {special}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        sb.append(String.format("###Evilness: %.2f", this.evilness))
        .append("\n");

        return sb.toString();
    }
}
