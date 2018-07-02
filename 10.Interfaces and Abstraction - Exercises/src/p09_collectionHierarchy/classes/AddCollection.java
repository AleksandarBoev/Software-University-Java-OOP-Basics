package p09_collectionHierarchy.classes;

import p09_collectionHierarchy.interfaces.IAddCollection;

public class AddCollection extends CustomCollection implements IAddCollection {


    @Override
    public int add(String item) {
        this.collection.add(item);
        return this.collection.lastIndexOf(item);
    }
}
