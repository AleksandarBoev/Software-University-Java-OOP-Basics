package classes;

import abstractClasses.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void tuneAllCars(int tuneIndex, String tuneAddOn) { //TODO not 100% sure this should be done here, but looks like it would work
        for (Car parkedCar : parkedCars) {
            parkedCar.tuneCar(tuneIndex, tuneAddOn);
        }
    }
}
