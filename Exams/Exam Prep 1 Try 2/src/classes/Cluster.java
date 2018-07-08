package classes;

import abstractClasses.Cell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    private List<Cell> getCells() {
        return this.cells;
    }

    public int getCellsCount() {
        return this.getCells().size();
    }

    public void addCell(Cell cell) {
        this.getCells().add(cell);
        //this.sortCells(); //should be added here, but stream sorting is slow and judge might give a time limit exception
    }

    public void sortCells() {
        //from word file in output section: Cells should be ordered by positionRow in ascending order, then by positionCol in ascending order
        this.cells = this.cells.stream()
                .sorted((cell1, cell2) -> {
                    int comparisonResult = Integer.compare(cell1.getPositionRow(), cell2.getPositionRow());

                    if (comparisonResult == 0) { //if they are on the same row, then compare them by column
                        comparisonResult = Integer.compare(cell1.getPositionCol(), cell2.getPositionCol());
                    }

                    return comparisonResult;
                }).collect(Collectors.toList());
    }

    public void activate() {
        if (this.getCellsCount() == 1) {
            return;
        }

        this.sortCells();
//after a battle in a cluster there will always be exactly one survivor cell and its position will always be the position of the last cell in the sorted list
        Cell lastCell = this.getCells().get(this.getCells().size() - 1);
        int survivorCellRow = lastCell.getPositionRow();
        int survivorCellCol = lastCell.getPositionCol();

        Cell survivorCell = this.cells.get(0);
        int numberOfCells = this.cells.size();
        for (int i = 0; i < numberOfCells - 1; i++) {
            survivorCell = survivorCell.fight(survivorCell, this.getCells().get(i + 1));
        }

        survivorCell.updatePosition(survivorCellRow, survivorCellCol);

        this.cells = new ArrayList<>();
        this.cells.add(survivorCell);
    }

    @Override
    public String toString() {
        this.sortCells();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s", this.getId())).append(System.lineSeparator());
        for (Cell cell : this.getCells()) {
            sb.append(cell.toString()).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
}
