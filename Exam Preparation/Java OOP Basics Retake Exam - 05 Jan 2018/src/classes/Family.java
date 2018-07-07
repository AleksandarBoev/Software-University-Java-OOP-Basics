package classes;

import abstractClasses.Colonist;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Family {
    private static final String FAMILY_IS_FULL_MESSAGE = "family is full";

    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public List<Colonist> getColonists() {
        return this.colonists; //good practise is to return an unmofiable list
    }

    public void addColonist(Colonist colonist, int maxMembersCount) {
        if (this.getColonists().size() == maxMembersCount) {
            throw new IllegalArgumentException(FAMILY_IS_FULL_MESSAGE);
        } else {
            this.getColonists().add(colonist);
        }
    }

    public void removeColonist(String colonistId) {
        Colonist colonistToBeRemoved = null; //TODO what if there is no such colonist in this family?
        for (Colonist colonist : this.getColonists()) {
            if (colonistId.equals(colonist.getId())) {
                colonistToBeRemoved = colonist;
                break;
            }
        }

        this.getColonists().remove(colonistToBeRemoved);
    }

    private void sortColonistsByIdAscending() {
        this.colonists = this.colonists.stream()
                .sorted((c1, c2) -> {
                    return c1.getId().compareTo(c2.getId());
                }).collect(Collectors.toList());
    }

    public boolean familyIsFull(int maxFamilyMembers) {
        return maxFamilyMembers == this.colonists.size();
    }

    public boolean familyIsEmpty() {
        return this.getColonists().isEmpty();
    }

    public int getFamilyPotential() {
        int result = 0;
        for (Colonist colonist : this.getColonists()) {
            result += colonist.getPotential();
        }

        return result;
    }

    public void growMembersAges(int years) {
        for (Colonist colonist : this.getColonists()) {
            colonist.grow(years);
        }
    }

    public int getNumberOfCurrentMembers() {
        return this.getColonists().size();
    }

    @Override
    public String toString() {
        //S1:
        //-Stefcho: 10
        this.sortColonistsByIdAscending();
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(":")
                .append("\n");

        for (Colonist colonist : this.getColonists()) {
            sb.append(colonist.toString())
            .append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
}
