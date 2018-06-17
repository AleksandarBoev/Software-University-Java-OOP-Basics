package p06_footballTeamGenerator;

public class Player {
    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private static final String INVALID_STATS_MESSAGE = "%s should be between 0 and 100.";

    private String name;
    private Integer endurance;
    private Integer sprint;
    private Integer dribble;
    private Integer passing;
    private Integer shooting;

    public Player(String name, Integer endurance, Integer sprint, Integer dribble, Integer passing, Integer shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
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

    private void setEndurance(Integer endurance) {
        if (!this.isBetween0And100(endurance)) {
            throw new IllegalArgumentException(String.format(INVALID_STATS_MESSAGE, "Endurance"));
        }

        this.endurance = endurance;
    }

    private void setSprint(Integer sprint) {
        if (!this.isBetween0And100(sprint)) {
            throw new IllegalArgumentException(String.format(INVALID_STATS_MESSAGE, "Sprint"));
        }
        this.sprint = sprint;
    }

    private void setDribble(Integer dribble) {
        if (!this.isBetween0And100(dribble)) {
            throw new IllegalArgumentException(String.format(INVALID_STATS_MESSAGE, "Dribble"));
        }
        this.dribble = dribble;
    }

    private void setPassing(Integer passing) {
        if (!this.isBetween0And100(passing)) {
            throw new IllegalArgumentException(String.format(INVALID_STATS_MESSAGE, "Passing"));
        }
        this.passing = passing;
    }

    private void setShooting(Integer shooting) {
        if (!this.isBetween0And100(shooting)) {
            throw new IllegalArgumentException(String.format(INVALID_STATS_MESSAGE, "Shooting"));
        }
        this.shooting = shooting;
    }

    private boolean isBetween0And100(Integer stat) {
        return stat >= 0 && stat <= 100;
    }

    protected int getAllPoints() {
        return this.endurance + this.dribble + this.shooting + this.passing + this.sprint;
    }
}
