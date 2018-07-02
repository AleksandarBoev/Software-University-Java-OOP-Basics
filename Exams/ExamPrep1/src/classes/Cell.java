package classes;

public abstract class Cell {
    //⦁	id – a String, nonunique property;
    //⦁	health – a positive integer;
    //⦁	positionRow – a positive integer;
    //⦁	positionCol – a positive integer;
    private String id;
    protected int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    @Override
    public String toString() {
        return null;
    }

    public abstract int getEnergy();
}
