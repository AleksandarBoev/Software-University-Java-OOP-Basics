package classes;

public abstract class Microbe extends Cell {
    protected int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    //When a Microbe meets another Microbe or a Blood cell, it attacks. When the cell attacks, the
    // target takes damage, equal to the energy of the attacking cell. Each cell has energy and it depends
    // on the other stats of the cell.
}
