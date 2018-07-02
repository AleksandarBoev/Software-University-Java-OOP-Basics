package p09_collectionHierarchy.classes;

import p09_collectionHierarchy.interfaces.IMyList;

public class MyList extends CustomCollection implements IMyList {
    @Override
    public int add(String item) {
        this.collection.add(0, item);
        return this.collection.indexOf(item);
    }

    @Override
    public String remove() {
        String result =  this.collection.get(0);
        this.collection.remove(0);
        return result;
    }

    @Override
    public int used() {
        return this.collection.size();
    }
}
