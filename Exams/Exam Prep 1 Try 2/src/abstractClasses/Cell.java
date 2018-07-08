package abstractClasses;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    protected String getId() {
        return this.id;
    }

    protected int getHealth() {
        return this.health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void updatePosition(int newRowPosition, int newColPosition) {
        this.positionRow = newRowPosition;
        this.positionCol = newColPosition;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n", this.getId(), this.getPositionRow(), this.getPositionCol());
    }

    protected abstract int getEnergy();

    public abstract Cell fight(Cell attackingCell, Cell defendingCell);
}
