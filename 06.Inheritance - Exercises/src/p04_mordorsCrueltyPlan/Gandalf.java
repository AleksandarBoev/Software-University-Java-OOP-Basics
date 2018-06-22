package p04_mordorsCrueltyPlan;

import java.util.Map;

public class Gandalf {
    private static final Map<String, Integer> FOODS_AND_THEIR_HAPPINESS_POINTS = Map.of(
            "cram", 2,
            "lembas", 3,
            "apple", 1,
            "melon", 1,
            "honeycake", 5,
            "mushrooms", -10
    );

    private int happyPoints;

    public Gandalf() {
        this.happyPoints = 0;
    }

    public int getHappyPoints() {
        return this.happyPoints;
    }

    public void eatFood(String foodName) {
        foodName = foodName.toLowerCase();
        if (!FOODS_AND_THEIR_HAPPINESS_POINTS.containsKey(foodName)) {
            this.happyPoints--;
        } else {
            this.happyPoints += FOODS_AND_THEIR_HAPPINESS_POINTS.get(foodName);
        }
    }

    public String getMood() {
        if (this.happyPoints < -5) {
            return "Angry";
        } else if (this.happyPoints <= 0) {
            return "Sad";
        } else if (this.happyPoints <= 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
