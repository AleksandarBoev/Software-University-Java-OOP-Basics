package classes;

import abstractClasses.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    private int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health: %d | Size: %d | Energy: %d", this.getHealth(), this.getSize(), this.getEnergy());
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + this.getSize()) * 2;
    }
}
