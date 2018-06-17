package p06_footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private static final String MISSING_PLAYER_NAME_MESSAGE = "Player %s is not in %s team.";

    private Map<String, Player> namePlayers;
    private String name;

    public Team(String name) {
        this.setName(name);
        this.namePlayers = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        this.namePlayers.put(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        if (!this.namePlayers.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format(MISSING_PLAYER_NAME_MESSAGE, playerName, this.name));
        }

        this.namePlayers.remove(playerName);
    }

    public String getRating() {
        int sumAllPoints = 0;
        for (Player player : namePlayers.values()) {
            sumAllPoints += player.getAllPoints();
        }

        if (sumAllPoints == 0) {
            return String.format("%s - 0", this.name);
        } else {
            return String.format("%s - %.0f", this.name, sumAllPoints * 1.0 / (namePlayers.size() * 5)); //TODO possible calculation problems!
        }
    }
}
