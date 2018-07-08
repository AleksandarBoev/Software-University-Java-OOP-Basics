package abstractClasses;

import classes.Bacteria;

public abstract class Cell {
    //⦁	id – a String, nonunique property;
    //⦁	health – a positive integer;
    //⦁	positionRow – a positive integer;
    //⦁	positionCol – a positive integer;
    private String id;
    protected int health;
    private int positionRow;
    private int positionCol;
    protected int additionalAttribute;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAdditionalAttribute() {
        return this.additionalAttribute;
    }

    @Override
    public String toString() {
        //------Cell V1 [0,0]
        //--------Health: 10 | Virulence: 10 | Energy: 20

        return null;
    }

    public abstract String getAdditionalProperty();

    public abstract int getEnergy();

    public abstract String getCellType();

    public abstract String getSpecificCellType();
}
