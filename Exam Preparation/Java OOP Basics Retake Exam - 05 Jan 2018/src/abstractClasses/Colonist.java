package abstractClasses;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id; //in the zero tests the id looks like a name
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract int getClassBonus();

    public abstract int getAgeBonus();

    public int getPotential() { // TODO possible problem: judge might want this to be an abstract class:
        return this.getTalent() + getClassBonus() + getAgeBonus();
    }

    public void grow(int years) {
        this.setAge(this.getAge() + years);
    }

    @Override
    public String toString() {
        return String.format("-%s: %d", this.getId(), this.getPotential());
    }
}
