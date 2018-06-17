package p05_pizzaCalories;

import java.util.Map;

public class Topping {
    private static final double BASE_CALORIES_PER_GRAM = 2.0;

    private static final Map<String, Double> VALID_TOPPINGS = Map.of(
            "Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9);
    private static final String INVALID_TOPPING_NAME_MESSAGE = "Cannot place %s on top of your pizza.";
    private static final String INVALID_TOPPING_WIGHT_MESSAGE = "%s weight should be in the range [1..50].";

    private String topping;
    private double toppingWeight;

    public Topping(String topping, double toppingWeight) {
        setTopping(topping);
        setToppingWeight(toppingWeight);
    }

    private void setTopping(String topping) {
        if (!VALID_TOPPINGS.containsKey(topping)) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_NAME_MESSAGE, topping));
        }

        this.topping = topping;
    }

    private void setToppingWeight(double toppingWeight) {
        if (toppingWeight < 1 || toppingWeight > 50) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_WIGHT_MESSAGE, this.topping));
        }

        this.toppingWeight = toppingWeight;
    }

    public double getToppingTotalCalories() {
        return BASE_CALORIES_PER_GRAM * this.toppingWeight * VALID_TOPPINGS.get(this.topping);
    }
}
