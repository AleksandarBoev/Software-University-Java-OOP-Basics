package p09_collectionHierarchy.classes;

import p09_collectionHierarchy.interfaces.IAddCollection;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomCollection {
    protected List<String> collection;

    public CustomCollection() {
        this.collection = new ArrayList();
    }
}
