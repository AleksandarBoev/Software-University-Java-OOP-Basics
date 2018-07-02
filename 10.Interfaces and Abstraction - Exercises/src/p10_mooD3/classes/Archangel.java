package p10_mooD3.classes;

public class Archangel extends GameObjects {
    private int mana;

    public Archangel(String userName, int level, int mana) {
        super(userName, level);
        this.mana = mana;
        type = "Archangel";
    }

    @Override
    public void setHashedPassword() {
        this.hashedPassword = new StringBuilder(this.getUserName()).reverse().toString() + (this.getUserName().length() * 21);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(this.getLevel() * this.mana);

        return sb.toString();
    }
}
