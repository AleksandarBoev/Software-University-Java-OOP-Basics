package classes;

import abstractClasses.Microbe;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String getAdditionalProperty() {
        return "Virulence";
    }

    @Override
    public int getEnergy() {
        return this.health + this.virulence;
    }

    @Override
    public String getSpecificCellType() {
        return "Virus";
    }
}
