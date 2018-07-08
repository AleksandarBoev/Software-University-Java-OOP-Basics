package classes;

import java.util.ArrayList;
import java.util.List;

public class Organism {
    //The organism has 1 property set trough the constructor:
    //⦁	name – a string that describes the name of the Organism;
    //And one additional property:
    //⦁	clusters – a collection of objects of type Cluster;
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Cluster> getClusters() {
        return this.clusters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Organism - Troli
        //--Clusters: 0
        //--Cells: 0
        sb.append("Organism - ").append(this.name).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.clusters.size()).append(System.lineSeparator());
        sb.append("--Cells: ").append(this.getCellsCount()).append(System.lineSeparator());

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString()).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    private int getCellsCount() {
        int count = 0;
        for (Cluster cluster : clusters) {
            for (int row = 0; row < cluster.getRows(); row++) {
                for (int col = 0; col < cluster.getCols(); col++) {
                    if (cluster.getCellsMatrix()[row][col] != null) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
