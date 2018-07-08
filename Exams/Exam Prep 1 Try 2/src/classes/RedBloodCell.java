package classes;

import abstractClasses.BloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    private int getVelocity() {
        return this.velocity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health: %d | Velocity: %d | Energy: %d", this.getHealth(), this.getVelocity(), this.getEnergy());
    }

    @Override
    public int getEnergy() {
        return this.getHealth() + this.getVelocity();
    }
}
