package p05_pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaTokens = reader.readLine().split(" ");
            String pizzaName = pizzaTokens[1];
            int pizzaNumberOfToppings = Integer.parseInt(pizzaTokens[2]);
            Pizza pizza = new Pizza(pizzaName, pizzaNumberOfToppings);

            String[] doughTokens = reader.readLine().split(" ");
            String flourType = doughTokens[1];
            String bakingTechnique = doughTokens[2];
            double weight = Double.parseDouble(doughTokens[3]);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String input;
            while (!"END".equals(input = reader.readLine())) {
                String[] toppingTokens = input.split(" ");

                String typeOfTopping = toppingTokens[1];
                double toppingWeight = Double.parseDouble(toppingTokens[2]);

                Topping topping = new Topping(typeOfTopping, toppingWeight);

                pizza.addTopping(topping);
            }

            System.out.println(pizza.getPizzaTotalCalories());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        //main ends here
    }
}
