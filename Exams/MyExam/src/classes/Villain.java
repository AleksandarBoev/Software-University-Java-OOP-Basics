package classes;

import abstractClasses.AntiHero;

import java.util.List;

public class Villain extends AntiHero {
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        // (intelligence * special) / energy.
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        sb.append(String.format("####Villain Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
