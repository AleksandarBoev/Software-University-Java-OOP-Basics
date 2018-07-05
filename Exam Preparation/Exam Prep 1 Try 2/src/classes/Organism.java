package classes;

import java.util.HashSet;
import java.util.Set;

public class Organism {
    private String name;
    private Set<Cluster> clusters; // TODO could make it into a Map<String, Cluster> idCluster

    public Organism(String name) {
        this.name = name;
        this.clusters = new HashSet<>();
    }

    @Override
    public String toString() {
        return null;
    }
}
