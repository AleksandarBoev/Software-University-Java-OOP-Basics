package abstractClasses;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public Cell fight(Cell attackingCell, Cell defendingCell) {
        attackingCell.setHealth(attackingCell.getHealth() + defendingCell.getHealth());
        return attackingCell; // if a blood cell is attacking it will ALWAYS win, devouring the other cell
    }

}
