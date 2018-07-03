package engine;

import classes.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> nameOrganism;

    public HealthManager() {
        this.nameOrganism = new LinkedHashMap<>();
    }

    public Map<String, Organism> getNameOrganism() {
        return this.nameOrganism;
    }

    public String checkCondition(String organismName) {
        //⦁	RETURNS detailed information about the condition of the organism with the given name
        return this.nameOrganism.toString();
    }
    public String createOrganism(String name) {
        if (this.nameOrganism.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        } else {
            this.nameOrganism.put(name, new Organism(name));
            return String.format("Created organism %s", name);
        }
    }


    public String addCluster(String organismName, String id, int rows, int cols) {
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

        for (Cluster cluster : this.nameOrganism.get(organismName).getClusters()) { // dobavqne na kletkata v PRAVILNIQ kluster
            if (cluster.getId().equals(clusterId)) {
                cluster.addCell(cell);
            }
        }

        return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
//⦁	FINDS the organism with the given name
//⦁	ACTIVATES the next cluster in order
//⦁	RETURNS message "Organism <organism name>: Activated cluster <cluster id>. Cells left: <cells count>"

        Cluster currentCluster = this.nameOrganism.get(organismName).getClusters().get(0);

        int[] lastCellCoordinates = currentCluster.getLastCellCoordinates();

        int rows = currentCluster.getRows();
        int cols = currentCluster.getCols();
        Cell survivor = null;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell currentCell = currentCluster.getCellsMatrix()[row][col];
                if (currentCell != null) {
                    if (survivor == null) {
                        survivor = currentCell;
                    } else {
                        survivor = currentCluster.fight(survivor, currentCell);
                    }
                }
            }
        }

        survivor.setPositionRow(lastCellCoordinates[0]);
        survivor.setPositionCol(lastCellCoordinates[1]);
        currentCluster = new Cluster(currentCluster.getId(), currentCluster.getRows(), currentCluster.getCols());
        currentCluster.addCell(survivor);

        //After a cluster is activated, it should wait for all the other clusters until it can be activated again.
        this.nameOrganism.get(organismName).getClusters().remove(0);
        this.nameOrganism.get(organismName).getClusters().add(currentCluster);

        return null; //Organism Troli: Activated cluster X05. Cells left: 1
    }

}
