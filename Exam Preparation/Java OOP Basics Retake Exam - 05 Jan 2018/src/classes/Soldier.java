package classes;

import abstractClasses.Colonist;

public class Soldier extends Colonist {
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getClassBonus() {
        return 3;
    }

    @Override
    public int getAgeBonus() {
        return 3;
    }


}
