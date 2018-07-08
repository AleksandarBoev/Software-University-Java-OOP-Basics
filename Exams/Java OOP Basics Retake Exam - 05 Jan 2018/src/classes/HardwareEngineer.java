package classes;

import abstractClasses.Engineer;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getAgeBonus() {
        if (super.getAge() < 18) {
            return 2;
        } else {
            return 0;
        }
    }
}
