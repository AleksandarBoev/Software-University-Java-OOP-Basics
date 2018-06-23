package p03_wildFarm.food_package;

public abstract class Food {
    private int quantity;
    protected String foodType;

    public Food(int quantity) {
        setQuantity(quantity);
        setFoodType();
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected abstract void setFoodType();

    public String getFoodType() {
        return this.foodType;
    }
}
