package p05_pizzaCalories;

import java.util.Map;
import java.util.Set;

public class Dough {
    private static final double BASE_CALORIES_PER_GRAM = 2.0;

    private static final Map<String, Double> VALID_TYPES_OF_DOUGH = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0);

    private static final Map<String, Double> VALID_TYPES_OF_BAKING_TECHNIQUE = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    private static final String INVALID_TYPE_OF_DOUGH_OR_BAKING_TECHNIQUE_MESSAGE = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_OF_DOUGH_MESSAGE = "Dough weight should be in the range [1..200].";

    private String dough;
    private String bakingTechnique;
    private double doughWeight;

    public Dough(String dough, String bakingTechnique, double doughWeight) {
        this.setDough(dough);
        this.setBakingTechnique(bakingTechnique);
        this.setDoughWeight(doughWeight);
    }

    private void setDough(String dough) {
        if (!VALID_TYPES_OF_DOUGH.containsKey(dough)) {
            throw new IllegalArgumentException(INVALID_TYPE_OF_DOUGH_OR_BAKING_TECHNIQUE_MESSAGE);
        }

        this.dough = dough;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!VALID_TYPES_OF_BAKING_TECHNIQUE.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException(INVALID_TYPE_OF_DOUGH_OR_BAKING_TECHNIQUE_MESSAGE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setDoughWeight(double doughWeight) {
        if (doughWeight < 0 || doughWeight > 200) {
            throw new IllegalArgumentException(INVALID_WEIGHT_OF_DOUGH_MESSAGE);
        }

        this.doughWeight = doughWeight;
    }

    public double getDoughTotalCalories() {
        return BASE_CALORIES_PER_GRAM * this.doughWeight * VALID_TYPES_OF_DOUGH.get(this.dough) * VALID_TYPES_OF_BAKING_TECHNIQUE.get(this.bakingTechnique);
    }
}
