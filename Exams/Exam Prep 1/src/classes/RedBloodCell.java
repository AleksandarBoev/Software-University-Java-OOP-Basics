package classes;

import abstractClasses.BloodCell;

public class RedBloodCell extends BloodCell {
    //⦁	velocity – a positive integer that describes the speed of the cell.
    //The velocity should be set trough the constructor.
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
        this.additionalAttribute = velocity;
    }

    @Override
    public String getAdditionalProperty() {
        return "Velocity";
    }

    @Override
    public int getEnergy() {
        return this.health + this.velocity;
    }

    @Override
    public String getSpecificCellType() {
        return "RedBloodCell";
    }
}
