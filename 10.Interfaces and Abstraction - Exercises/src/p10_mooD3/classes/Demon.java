package p10_mooD3.classes;

public class Demon extends GameObjects {
    private double energy;

    public Demon(String userName, int level, double energy) {
        super(userName, level);
        this.energy = energy;
        type = "Demon";
    }

    @Override
    public void setHashedPassword() {
        this.hashedPassword = this.getUserName().length() * 217 + "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(this.getLevel() * this.energy);

        return sb.toString();
    }
}
