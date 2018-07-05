package classes;

import java.util.ArrayDeque;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private ArrayDeque<String> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayDeque<>();
    }

    @Override
    public String toString() {
        return null;
    }
}
