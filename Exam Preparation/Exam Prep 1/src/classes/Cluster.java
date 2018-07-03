package classes;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cellsMatrix;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cellsMatrix = new Cell[rows][cols];
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    @Override
    public String toString() {
        return null;
    }

    public Cell[][] getCellsMatrix() {
        return this.cellsMatrix;
    }

    public Cell fight(Cell attackingCell, Cell defendingCell) {
        if ("BloodCell".equalsIgnoreCase(attackingCell.getCellType())) {
            attackingCell.health += defendingCell.health;
            return attackingCell;
        } else  { //Its a microbe
            while (true) {
                defendingCell.health -= attackingCell.getEnergy();
                if (defendingCell.health <= 0) {
                    return attackingCell;
                }

                attackingCell.health -= defendingCell.getEnergy(); //counter attack
                if (attackingCell.health <= 0) {
                    return defendingCell;
                }
            }
        }
    }

    public void addCell(Cell cell) {
        this.cellsMatrix[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    public int getCellsCount() {
        int count = 0;

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                if (this.getCellsMatrix()[row][col] != null) {
                    count++;
                }
            }
        }

        return count;
    }

    public int[] getLastCellCoordinates() {
        for (int row = this.rows - 1; row >= 0; row--) {
            for (int col = this.cols - 1; col >= 0; col--) {
                if (this.getCellsMatrix()[row][col] != null) {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }

}
