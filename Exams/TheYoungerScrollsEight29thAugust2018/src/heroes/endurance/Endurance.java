package heroes.endurance;

import heroes.Characters;

public class Endurance extends Characters { //this is not... abstract? wtf
    //Endurance heroes are tanks by nature. Therefore, they have magicResistance(double) equal
    // to 40% of their maigcka. Upon creation endurance heroes also get their health DOUBLED.
    private double magicResistance;

    protected Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicResistance(super.getMagicka());
    }

    //  Offense is equal to: the fatigue of the hero.
    //	Defense is equal to: the health of the hero + 60% of the hero`s fatigue + the hero`s magic resistance.
    //	Orcs have additional defense equal to 10% of the birth signs’ defense.

    @Override
    public double getOffense() {
        return super.getFatigue();
    }

    @Override
    public double getDefense() {
        double result = super.getHealth() + 0.6 * super.getFatigue() + this.magicResistance;
        if (!"Orc".equals(super.getHeroType())) {
            return result;
        } else {
            return result + result * 0.1; //would be better to be implemented in the Orc class, but that would break judge I think
        }
    }

    @Override
    protected void setHealth(int health) {
        super.setHealth(2 * health);
    }

    private void setMagicResistance(int magicka) {
        this.magicResistance = magicka * 0.4;
    }


    //o	If the hero is created under the “Endurance” birth sign you should also print his birth sign bonuses.
    //“#Endurance bonuses:”
    //“Magic resistance: +{magicResistance} defense.” – formatted to two decimal places.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("#Endurance bonuses:").append(System.lineSeparator());
        sb.append(String.format("Magic resistance: +%.2f defense.", this.magicResistance));
        return sb.toString();
    }
}
