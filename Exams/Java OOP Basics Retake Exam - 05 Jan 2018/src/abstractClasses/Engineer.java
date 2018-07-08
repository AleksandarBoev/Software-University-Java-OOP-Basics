package abstractClasses;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getClassBonus() {
        return 3;
    }

    @Override
    public int getAgeBonus() {
        if (this.getAge() > 30) { //TODO possible problem -> might be >= 30
            return 2;
        } else {
            return 0;
        }
    }
}
