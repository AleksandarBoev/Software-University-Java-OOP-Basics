package classes;

import abstractClasses.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return this.parkedCars;
    }

    public void tuneAllCars(int tuneIndex, String tuneAddOn) { //TODO not 100% sure this should be done here, but looks like it would work
        if (this.parkedCars.isEmpty()) { //IGNORE any attempt to TUNE cars, when there are NO PARKED cars in the garage.
            return;
        }

        for (Car parkedCar : parkedCars) {
            parkedCar.tuneCar(tuneIndex, tuneAddOn);
        }
    }
}
