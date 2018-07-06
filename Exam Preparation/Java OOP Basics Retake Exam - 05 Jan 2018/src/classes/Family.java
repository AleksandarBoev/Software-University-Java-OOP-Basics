package classes;

import abstractClasses.Colonist;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String id;
    //collection of colonists? the size will be predefined, but operations with an array might be anoying to do
    private List<Colonist> colonists; //TODO should be sorted at all times, but there is no such list type.
    // Also there is a colony method which returns a List<Colonist> so that means this has? to be a list of colonists? Dunno read again

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }
}
