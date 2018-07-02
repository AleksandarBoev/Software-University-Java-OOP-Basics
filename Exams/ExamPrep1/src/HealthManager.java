import classes.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public abstract class HealthManager {
    private Map<String, Organism> nameOrganism;

    public HealthManager(Map<String, Organism> nameOrganism) {
        this.nameOrganism = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        //⦁	RETURNS detailed information about the condition of the organism with the given name
        return this.nameOrganism.toString();
    }
    public String createOrganism(String name) {
//⦁	CREATES an organism with the given name
//⦁	RETURNS message "Created organism <name>"
//⦁	If an organism with the same name already exists, returns message "Organism <name> already exists"

        if (this.nameOrganism.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        } else {
            this.nameOrganism.put(name, new Organism(name));
            return String.format("Created organism %s", name);
        }
    }
    public String addCluster(String organismName, String id, int rows, int cols) {
//⦁	CREATES a cluster with the given id, rows and cols
//⦁	ADDS the cluster to the cluster collection of the organism with the given name
//⦁	If the organism already has a cluster with the same Id, nothing happens
//⦁	RETURNS message "Organism <organism name>: Created cluster <cluster id>";
        long hasThisClusterId = this.nameOrganism.get(organismName).getClusters().stream()
                .map(x -> x.getId())
                .filter(x -> x.equals(id))
                .count();

        if (hasThisClusterId == 1) {
            return ""; //TODO or return null
        }

        Cluster cluster = new Cluster(id, rows, cols);
        this.nameOrganism.get(organismName).getClusters().add(cluster);
        return String.format("Organism %s: Created cluster %s", organismName, id);
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId
            , int health, int positionRow, int positionCol, int additionalProperty) {
//⦁	CREATES a cell of the given type with the given id, health, positionRow, positionCol,
// and the given additional property (size, velocity or virulense).

//⦁	FINDS the organism with given name, find the cluster with given id in the cluster collection
// of that organism and ADDS the cell to the cells collection of that cluster
//⦁	RETURNS message "Organism <organism name>: Created cell <cell id> in cluster <cluster id>"
        Cell cell = null;
        switch (cellType) {
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

        for (Cluster cluster : this.nameOrganism.get(organismName).getClusters()) {
            if (cluster.getId().equals(clusterId)) {
                cluster.getCells().add(cell);
            }
        }

        return String.format("Organism %s: Created cell %s in cluster %s",
                organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
//⦁	FINDS the organism with the given name
//⦁	ACTIVATES the next cluster in order
//⦁	RETURNS message "Organism <organism name>: Activated cluster <cluster id>. Cells left: <cells count>"
        //Organism Troli: Activated cluster X05. Cells left: 1
        Cluster currentCluster = this.nameOrganism.get(organismName).getClusters().get(0);
        Cell currentCell = currentCluster.findFirstCell(); //think of a method for finding a cell
        
        // think of a method of moving the cell one position to the right and a fight method which returns the winner Cell
        //TODO do stuff with this cluster
        //After a cluster is activated, it should wait for all the other clusters until it can be activated again.
        this.nameOrganism.get(organismName).getClusters().remove(0);
        this.nameOrganism.get(organismName).getClusters().add(currentCluster);

        return null;
    }

}
