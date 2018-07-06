package engine;

import abstractClasses.Colonist;

import java.util.List;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public void addColonist(Colonist colonist) {

    }

    public void removeColonist(String familyId, String memberId) {

    }

    public void removeFamily(String id) {

    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return null;
    }

    public void grow(int years) {

    }

    public int getPotential() {
        return 0;
    }

    public String getCapacity() {
        return null;
    }

}
