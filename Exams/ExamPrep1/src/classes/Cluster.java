package classes;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    //⦁	id – a string that describes the name of the cluster, unique property;
    //⦁	rows – a positive integer that describes how many rows the cluster has;
    //⦁	cols – a positive integer that describes how many columns the cluster has;
    //⦁	cells – a collection of objects of type Cell;
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;
    private Cell activeCell; //TODO not sure if this is going to create problems

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    @Override
    public String toString() {
        return null;
    }

    public String getId() {
        return this.id;
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    public Cell findFirstCell() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                for (Cell cell : cells) {
                    if (row == cell.getPositionRow() && col == cell.getPositionCol()) {
                        return cell;
                    }
                }
            }
        }

        return null; // TODO ne bi trqbvalo tova da napravi problem, no vse pak malko kuca logikata mai
    }

    //TODO dali nqma da e po-dobre da si go napravq kato matrica, ili da si bluskam metodi...

//    public Cell findNextCell() {
//
//    }
}
