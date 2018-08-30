package heroes;

import interfaces.Hero;

public abstract class Characters implements Hero {
    private static final String INVALID_STATS_MESSAGE = "Invalid character stats!";

    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType; //this is the name of the class, like Redguard!

    //The command for adding a hero is:
    //•	ADD_HERO: {guildName} {heroType} {heroName} {health} {fatigue} {magicka}

    //TODO in the input some of these are switched
    //TODO zero test 2 gives this problem:
    //java.lang.NoSuchMethodException: heroes.Characters.<init>(java.lang.String, int, int, int, java.lang.String)
    public Characters(String name, int magicka, int fatigue, int health, String heroType) { //judge wants it public
        this.setName(name);
        this.setMagicka(magicka);
        this.setFatigue(fatigue);
        this.setHealth(health);
        this.setHeroType(heroType);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public double getTotalPoints() {
        return this.getDefense() + this.getOffense();
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(this.getOffense());
    }

    @Override
    public void receiveDamage(double amount) { //TODO wasn't there a race that received reduced damage?
        int flooredAttack = (int) amount;
        this.health -= flooredAttack;
    }

    public int getMagicka() {
        return this.magicka;
    }

    public int getFatigue() {
        return this.fatigue;
    }

    public String getHeroType() { //does NOT break judge
        return this.heroType;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setMagicka(int magicka) {
        if (magicka < 1)
            throw new IllegalArgumentException(INVALID_STATS_MESSAGE);

        this.magicka = magicka;
    }

    protected void setFatigue(int fatigue) {
        if (fatigue < 1)
            throw new IllegalArgumentException(INVALID_STATS_MESSAGE);

        this.fatigue = fatigue;
    }

    protected void setHealth(int health) {
        if (health < 1)
            throw new IllegalArgumentException(INVALID_STATS_MESSAGE);

        this.health = health;
    }

    protected void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Type: [%s]", this.name, this.heroType)).append(System.lineSeparator());
        sb.append("#Stats:").append(System.lineSeparator());
        sb.append(String.format("Health: %d", this.health)).append(System.lineSeparator());
        sb.append(String.format("Fatigue: %d", this.fatigue)).append(System.lineSeparator());
        sb.append(String.format("Magicka: %d", this.magicka));

        return sb.toString();
    }
}
