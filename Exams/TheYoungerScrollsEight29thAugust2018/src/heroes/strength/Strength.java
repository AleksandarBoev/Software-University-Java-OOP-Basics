package heroes.strength;

import heroes.Characters;

public class Strength extends Characters {
    //Every strength hero has magicDamage(double) equal to 50% of the their magicka
    private double magicDamage;

    protected Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicDamage(super.getMagicka());
    }

    //	Offense is equal to: 125% of the hero`s fatigue + 30% of the health + the hero`s magic damage.
    //	Defense is equal to: the hero`s health + 10% of the hero`s fatigue.

    @Override
    public double getOffense() {
        return super.getFatigue() * 1.25 + (super.getHealth() * 0.3) + this.magicDamage;
    }

    @Override
    public double getDefense() {
        return super.getHealth() + 0.1 * super.getFatigue();
    }

    private void setMagicDamage(int magicka) {
        this.magicDamage = magicka * 0.5;
    }

    //“#Strength bonuses:”
    //“Magic damage: +{magicDamage} offense.” - formatted to two decimal places.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append("#Strength bonuses:").append(System.lineSeparator());
        sb.append(String.format("Magic damage: +%.1f offense.", this.magicDamage));
        return sb.toString();
    }
}
