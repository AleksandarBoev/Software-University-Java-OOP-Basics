package classes;

import abstractClasses.Cell;

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

    public Cell[][] getCellsMatrix() {
        return this.cellsMatrix;
    }

    public Cell fight(Cell attackingCell, Cell defendingCell) {
        if ("BloodCell".equalsIgnoreCase(attackingCell.getCellType())) {
            attackingCell.setHealth(attackingCell.getHealth() + defendingCell.getHealth());
            return attackingCell;
        } else  { //Its a microbe
            while (true) {
                defendingCell.setHealth(defendingCell.getHealth() - attackingCell.getEnergy());
                if (defendingCell.getHealth() <= 0) {
                    return attackingCell;
                }

                attackingCell.setHealth(attackingCell.getHealth() - defendingCell.getEnergy()); //counter attack
                if (attackingCell.getHealth() <= 0) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s", this.getId())).append(System.lineSeparator());
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Cell currentCell = getCellsMatrix()[row][col];
                if (currentCell != null) {
                    sb.append(String.format("------Cell %s [%d,%d]", currentCell.getId(), currentCell.getPositionRow(), currentCell.getPositionCol()))
                            .append(System.lineSeparator());
                    sb.append(String.format("--------Health: %d | %s: %d | Energy: %d",
                            currentCell.getHealth(),currentCell.getAdditionalProperty(), currentCell.getAdditionalAttribute(),currentCell.getEnergy()))
                    .append("\n");
                }
            }
        }

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

}
