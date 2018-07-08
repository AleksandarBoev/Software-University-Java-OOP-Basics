package classes;

import abstractClasses.Car;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                   int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    private int getStars() {
        return this.stars;
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public void tuneCar(int tuneIndex, String tuneAddOn) {
        int additionalHorsePower = tuneIndex;
        int additionalSuspension = tuneIndex / 2;
        int additionalStars = tuneIndex;

        this.setHorsepower(this.getHorsepower() + additionalHorsePower);
        this.setSuspension(this.getSuspension() + additionalSuspension);
        this.setStars(this.getStars() + additionalStars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(super.toString());
        sb.append(this.getStars()).append(" *");

        return sb.toString();
    }
}
