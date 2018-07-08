package abstractClasses;

import classes.Power;
import interfaces.ComicCharacter;
import constants.Constants;
import interfaces.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.matches("[A-z_]{2,12}")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_COMIC_CHARACTER_NAME_MESSAGE);
        }

    }

    private void setEnergy(int energy) {
        if (energy >= 0 && energy <= 300) {
            this.energy = energy;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_ENERGY_MESSAGE);
        }
    }

    private void setHealth(double health) {
        if (health >= 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_HEALTH_MESSAGE);
        }
    }

    private void setIntelligence(double intelligence) {
        if (intelligence >= 0 && intelligence <= 200) {
            this.intelligence = intelligence;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_INTELLIGENCE_MESSAGE);
        }
    }

    //______________________________INTERFACE_IMPLEMENTATIONS______________________________________________________
    @Override
    public void takeDamage(double damage) {
        this.health -= damage; //damage is the attack points (calculated via "attack" method) of the attacker
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) { //also validates
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String useSuperPowers() {
        if (this.powers.isEmpty()) {
            return String.format("%s has no super powers!", this.name);
        }

        //If the character has powers , iterate over the colection and for every power:
        //	- add to characters energy the Super power points;
        //	- add to characters health the Super power points multiplied by two;
        //	returns "<comic character name> used his super powers!"
        for (SuperPower superPower: this.powers) {
            this.energy += superPower.getPowerPoints();
            this.health += superPower.getPowerPoints() * 2;
        }

        return String.format("%s used his super powers!", this.name);
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public String toString() {
        //#Name: Lex_Luthor
        //##Health: 300.50// Energy: 20// Intelligence: 40.72
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("#Name: %s", this.name))
                .append("\n");
        sb.append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f", this.health, this.energy, this.intelligence))
                .append("\n");

        return sb.toString();
    }

    //___________________________________________MY_METHODS_____________________________________________________________
    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public boolean hasPower(String powerName) {
        for (SuperPower power : this.powers) {
            if (power.getName().equals(powerName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasAtLeastOneSuperPower() {
        return !this.powers.isEmpty();
    }

}
