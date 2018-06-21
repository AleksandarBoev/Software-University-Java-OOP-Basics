package p04_fragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        Collections.addAll(this.foodEaten, food);
    }
}
