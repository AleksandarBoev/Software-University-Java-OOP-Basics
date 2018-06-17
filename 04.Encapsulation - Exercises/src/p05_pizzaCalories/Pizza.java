package p05_pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private static final String INVALID_PIZZA_NAME_MESSAGE = "Pizza name should be between 1 and 15 symbols.";
    private static final String INVALID_NUMBER_OF_TOPPINGS_MESSAGE = "Number of toppings should be in range [0..10].";

    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME_MESSAGE);
        }

        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_TOPPINGS_MESSAGE);
        }

        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        if (toppings.size() == numberOfToppings) { //doesn't fix last test
//            throw new IllegalArgumentException(INVALID_NUMBER_OF_TOPPINGS_MESSAGE); //doesn't fix last test
            return; // doesn't fix last test
        }

        this.toppings.add(topping);
    }

    private double getTotalCaloriesOfAllToppings() {
        return this.toppings.stream().mapToDouble(t -> t.getToppingTotalCalories()).sum();
    }

    private double getTotalCalories() {
        return getTotalCaloriesOfAllToppings() + this.dough.getDoughTotalCalories();
    }

    public String getPizzaTotalCalories() {
        return String.format("%s - %.2f", this.name, this.getTotalCalories());
    }

}
