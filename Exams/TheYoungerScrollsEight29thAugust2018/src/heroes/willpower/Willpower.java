package heroes.willpower;

import heroes.Characters;

public class Willpower extends Characters {
    //Willpower heroes fight with spells and since they have no use of fatigue they have
    // found a way to turn it into spellPentration (double) which is equal to 20% of the hero`s fatigue
    private double spellPenetration;

    protected Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setSpellPenetration(super.getFatigue());
    }

    //	Offense is equal to: 180% of the hero`s magicka + the hero`s spell penetration.
    @Override
    public double getOffense() {
        return super.getMagicka() * 1.8 + this.spellPenetration;
    }

    //	Defense is equal to: the health of the hero.
    @Override
    public double getDefense() {
        return super.getHealth();
    }

    private void setSpellPenetration(int fatigue) {
        this.spellPenetration = fatigue * 0.2;
    }

}
