package engine;

import abstractClasses.Cell;
import classes.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> nameOrganism;

    public HealthManager() {
        this.nameOrganism = new HashMap<>();
    }

    private Map<String, Organism> getNameOrganism() { //it is a good practise to return an unmodifiable map via getter
        return this.nameOrganism;
    }


    public String checkCondition(String organismName) {
        if (!this.organismExists(organismName)) {
            return "";
        }

        return this.getNameOrganism().get(organismName).toString() + "\n";
    }

    public String createOrganism(String name) {
        //o	" Created organism {organism name}" or
        //o	"Organism already exists"
        if (this.getNameOrganism().containsKey(name)) {
            return String.format("Organism %s already exists\n", name);
        } else {
            this.getNameOrganism().put(name, new Organism(name));
            return String.format("Created organism %s\n", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (!this.getNameOrganism().containsKey(organismName)) {
            return "";
        }

        Cluster cluster = new Cluster(id, rows, cols); //again, factory pattern is the best practise here
        Organism currentOrganism = this.getNameOrganism().get(organismName);

        if (currentOrganism.clusterAlreadyExists(cluster)) {
            return "";
        } else {
            currentOrganism.addCluster(cluster);
            return String.format("Organism %s: Created cluster %s\n", organismName, id);
        }
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        //o	CREATES a cell of the given type with the given id, health, positionRow, positionCol, and the given additional property (size, velocity or virulense).
        //o	FINDS the organism with given name, find the cluster with given id in the
        // cluster collection of that organism and ADDS the cell to the cells collection of that cluster
        //o	RETURNS message "Organism <organism name>: Created cell <cell id> in cluster <cluster id>"
        if (!organismExists(organismName)) {
            return "";
        }

        Organism currentOrganism = this.nameOrganism.get(organismName);
        if (currentOrganism.getClusterById(clusterId) == null) { // if there is no such cluster
            return "";
        }

        Cluster currentCluster = this.getNameOrganism().get(organismName).getClusterById(clusterId);
        Cell cell = null;
        switch (cellType) { //should be done via factory pattern
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;

            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;

            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;

            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;

            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }

        currentCluster.addCell(cell);

        return String.format("Organism %s: Created cell %s in cluster %s\n", organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
        if (!this.organismExists(organismName)) {
            return "";
        }
        Organism currentOrganism = this.getNameOrganism().get(organismName);

        if (currentOrganism.getClustersCount() == 0) {
            return "";
        }
        Cluster currentCluster = currentOrganism.popCluster(); // take it and remove it from the start of the queue

        currentCluster.activate(); // initiates battle, changes the cluster to have one remaining cell

        currentOrganism.addCluster(currentCluster); //add it back to the end of the queue

        return String.format("Organism %s: Activated cluster %s. Cells left: %d\n",
                organismName, currentCluster.getId(), currentCluster.getCellsCount());
    }

    public boolean organismExists(String organismName) {
        return (this.nameOrganism.containsKey(organismName));
    }

}
