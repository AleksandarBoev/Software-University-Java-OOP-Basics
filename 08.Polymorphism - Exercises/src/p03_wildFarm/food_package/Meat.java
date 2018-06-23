package p03_wildFarm.food_package;

public class Meat extends Food {
    public Meat(int quantity) {
        super(quantity);
    }

    @Override
    protected void setFoodType() {
        this.foodType = "Meat";
    }
}
