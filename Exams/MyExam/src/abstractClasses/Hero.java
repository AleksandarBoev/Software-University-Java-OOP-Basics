package abstractClasses;

import classes.Power;
import constants.Constants;

import java.util.List;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;


    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public void setHeroism(double heroism) {
        if (heroism >= 0) {
            this.heroism = heroism;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_HEROISM_MESSAGE);
        }
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        //•	###Heroism: {special}
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        sb.append(String.format("###Heroism: %.2f", this.heroism))
        .append("\n");

        return sb.toString();
    }
}
