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
        return null;
    }
}
