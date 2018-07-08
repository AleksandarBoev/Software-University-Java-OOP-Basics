package engine;

import abstractClasses.Colonist;
import classes.Family;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Colony {
    private static final String COLONY_IS_FULL_MESSAGE = "colony is full";

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> idFamily;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.idFamily = new TreeMap<>(); //will stay sorted by id.
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public Map<String, Family> getIdFamily() {
        return this.idFamily;
    }

    //__________________________________________________________________________________________________________________

    public void addColonist(Colonist colonist) {
        //SO when creating a colonist: family id --> if there is such a family then
        // check if there are avaliable slots. else check if one more family could be created
        //TODO make sure there isn't already a colonist with this id?
        String familyId = colonist.getFamilyId();

        if (!this.getIdFamily().containsKey(familyId)) { //if there is no such family
            if (this.getIdFamily().size() == this.getMaxFamilyCount()) { //if the max family capacity has been reached
                throw new IllegalArgumentException(COLONY_IS_FULL_MESSAGE); //method will stop here
            } else {
                this.idFamily.put(familyId, new Family(familyId));
            }
        }

        this.idFamily.get(familyId).addColonist(colonist, this.getMaxFamilyCapacity());
    }

    public void removeColonist(String familyId, String memberId) {
        Family currentFamily = this.getIdFamily().get(familyId);
        currentFamily.removeColonist(memberId);

        if (currentFamily.familyIsEmpty()) {
            this.getIdFamily().remove(familyId);
        }
    }

    public void removeFamily(String id) {
        //TODO what if there is no such family?
        this.getIdFamily().remove(id);
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (!this.getIdFamily().containsKey(familyId)) {
            return null;
        } else {
            return this.getIdFamily().get(familyId).getColonists();
        }
    }

    public void grow(int years) {
        for (Family family : idFamily.values()) {
            family.growMembersAges(years);
        }
    }

    public int getPotential() {
        int result = 0;

        for (Family family : this.getIdFamily().values()) {
            result += family.getFamilyPotential();
        }

        return result;
    }

    public String getCapacity() {
        //families: 2/2
        //-S2: 1/1
        //-S6: 1/1
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.getFamiliesCount(), this.getMaxFamilyCount()))
                .append("\n");

        for (Family family : this.getIdFamily().values()) {
            sb.append(String.format("-%s: %d/%d", family.getId(), family.getNumberOfCurrentMembers(), this.getMaxFamilyCapacity()))
                    .append("\n");
        }

        sb.delete(sb.length() - 1, sb.length()); //delete last new line

        return sb.toString();
    }

    //__________________________________________________________________________________________________________________

    private int getFamiliesCount() {
        return this.idFamily.size();
    }

}
