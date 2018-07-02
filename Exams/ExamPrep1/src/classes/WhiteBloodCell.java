package classes;

public class WhiteBloodCell extends BloodCell {
    //⦁	size – a positive integer that describes the size of the cell.
    //The size should be set trough the constructor.
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int getEnergy() {
        return (this.health + this.size) * 2;
    }

    //energy = (health + size) * 2.

}
