package abstractClasses;

public abstract class Microbe extends Cell{
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return this.virulence;
    }

    public Cell fight(Cell attackingCell, Cell defendingCell) {
        Cell winner;

        while (true) {
            defendingCell.setHealth(defendingCell.getHealth() - attackingCell.getEnergy());
            if (defendingCell.getHealth() <= 0) {
                return attackingCell;
            }

            attackingCell.setHealth(attackingCell.getHealth() - defendingCell.getEnergy());
            if (attackingCell.getHealth() <= 0) {
                return defendingCell;
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + String.format("--------Health: %d | Virulence: %d | Energy: %d", super.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
