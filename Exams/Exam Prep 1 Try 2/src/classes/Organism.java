package classes;

import java.util.*;

public class Organism {
    private String name;
    private ArrayDeque<Cluster> clusters; //queue --> add + pop

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayDeque<>();
    }

    private String getName() {
        return this.name;
    }

    private ArrayDeque<Cluster> getClusters() {
        return this.clusters;
    }

    public int getClustersCount() {
        return this.getClusters().size();
    }

    public int getAllCellsCount() {
        int count = 0;

        for (Cluster cluster : this.getClusters()) {
            count += cluster.getCellsCount();
        }

        return count;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public boolean clusterAlreadyExists(Cluster cluster) {
        for (Cluster currentCluster : clusters) {
            if (cluster.getId().equals(currentCluster.getId())) {
                return true;
            }
        }

        return false;
    }

    public Cluster getClusterById(String id) {
        for (Cluster cluster : clusters) {
            if (id.equalsIgnoreCase(cluster.getId())) {
                return cluster;
            }
        }

        return null;
    }

    public Cluster popCluster() {
        return this.getClusters().pop();
    }

    //Organism - Ivan
    //--Clusters: 2
    //--Cells: 5
    //----Cluster H9
    //------Cell V1 [0,0]
    //--------Health: 10 | Virulence: 10 | Energy: 20
    //------Cell F1 [0,1]
    //--------Health: 30 | Virulence: 20 | Energy: 12
    //------Cell RBC [1,1]
    //--------Health: 100 | Velocity: 20 | Energy: 120
    //------Cell WBC [1,2]
    //--------Health: 100 | Size: 30 | Energy: 260
    //----Cluster H8
    //------Cell B [1,2]
    //--------Health: 133 | Virulence: 10 | Energy: 47

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Organism - %s", this.getName()))
                .append("\n");

        sb.append("--Clusters: ").append(this.getClustersCount())
                .append("\n");

        sb.append("--Cells: ").append(this.getAllCellsCount()).append("\n");

        for (Cluster cluster : this.getClusters()) {
            sb.append(cluster.toString()).append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
}
