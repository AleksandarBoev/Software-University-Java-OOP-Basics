import classes.Organism;

import java.util.HashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> nameOrganism;

    public HealthManager() {
        this.nameOrganism = new HashMap<>();
    }

    private Map<String, Organism> getNameOrganism() {
        return this.nameOrganism;
    }

    public String checkCondition(String organismName) {
        return this.getNameOrganism().get(organismName).toString();
    }

    public String createOrganism(String name) {
        return null;
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return null;
    }

    public String activateCluster(String organismName) {
        return null;
    }

}
