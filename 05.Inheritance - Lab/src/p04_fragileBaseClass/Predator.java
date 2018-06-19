package p04_fragileBaseClass;

public class Predator extends Animal{
    private int health;

    @Override
    public void eat(Food food) {
        super.foodEaten.add(food);
        this.health++;
    }
}
