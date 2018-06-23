package p03_wildFarm.food_package;

public class Vegetable extends Food {
    public Vegetable(int quantity) {
        super(quantity);
    }

    @Override
    protected void setFoodType() {
        this.foodType = "Vegetable";
    }
}
