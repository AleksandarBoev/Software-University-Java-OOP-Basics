package p10_mooD3.classes;

import p10_mooD3.interfaces.IGameObjects;

public abstract class GameObjects implements IGameObjects {
    protected static String type;
    private String userName;
    protected String hashedPassword;
    private int level;

    public GameObjects(String userName, int level) {
        this.userName = userName;
        this.level = level;
        setHashedPassword();
    }

    protected String getUserName() {
        return this.userName;
    }

    protected String getHashedPassword() {
        return this.hashedPassword;
    }

    protected int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s", this.getUserName(), this.hashedPassword, type);
    }
}
