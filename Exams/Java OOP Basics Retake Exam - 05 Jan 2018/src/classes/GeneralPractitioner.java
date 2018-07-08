package classes;

import abstractClasses.Medic;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int result = super.getPotential();

        if ("caring".equals(super.getSign())) {
            result += 1;
        } else if ("careless".equals(super.getSign())) {
            result -= 2;
        }

        return result;
    }

    @Override
    public int getAgeBonus() {
        if (super.getAge() > 15) {
            return 1;
        } else {
            return 0;
        }
    }
}
