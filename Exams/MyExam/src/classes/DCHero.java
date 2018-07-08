package classes;

import abstractClasses.Hero;
import interfaces.SuperPower;

import java.util.List;

public class DCHero extends Hero {
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }


    @Override
    public double attack() {
        //energy / 1.5 + special + intelligence.
        return super.getEnergy() / 1.5 + super.getSpecial() + super.getIntelligence();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        //####DC Attack Power: {attack power}
        sb.append(String.format("####DC Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
