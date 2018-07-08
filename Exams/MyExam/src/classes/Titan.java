package classes;

import abstractClasses.AntiHero;

import java.util.List;

public class Titan extends AntiHero {
    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        //(energy + intelligence + special)  * 3.
        return (super.getEnergy() + super.getIntelligence() + super.getSpecial()) * 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        sb.append(String.format("####Titan Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
