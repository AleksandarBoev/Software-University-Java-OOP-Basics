package abstractClasses;

public abstract class Medic extends Colonist {
    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public int getClassBonus() {
        return 2;
    }
}
