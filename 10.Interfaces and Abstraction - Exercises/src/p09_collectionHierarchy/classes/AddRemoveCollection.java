package p09_collectionHierarchy.classes;

import p09_collectionHierarchy.interfaces.IAddRemoveCollection;

public class AddRemoveCollection extends CustomCollection implements IAddRemoveCollection {
    @Override
    public int add(String item) {
        this.collection.add(0, item);
        return this.collection.indexOf(item);
    }

    @Override
    public String remove() {
        String result = this.collection.get(this.collection.size() - 1);
        this.collection.remove(this.collection.size() - 1);
        return result;
    }
}
