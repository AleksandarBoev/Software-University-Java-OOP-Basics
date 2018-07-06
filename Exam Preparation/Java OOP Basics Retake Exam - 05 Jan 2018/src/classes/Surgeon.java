package classes;

import abstractClasses.Medic;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int result = super.getPotential();

        if ("precise".equals(super.getSign())) {
            result += 3;
        } else if ("butcher".equals(super.getSign())) {
            result -= 3;
        }

        return result;
    }

    @Override
    public int getAgeBonus() {
        if (super.getAge() > 25 && super.getAge() < 35) {
            return 2;
        } else {
            return 0;
        }
    }
}
