package engine;

import abstractClasses.Car;
import abstractClasses.Race;
import classes.CasualRace;
import classes.DragRace;
import classes.PerformanceCar;
import classes.ShowCar;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> idCar;
    private Map<Integer, Race> idRace;

    public CarManager() {
        this.idCar = new LinkedHashMap<>();
    }

    private Map<Integer, Car> getIdCar() {
        return this.idCar;
    }

    public Map<Integer, Race> getIdRace() {
        return this.idRace;
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction,
                         int horsepower, int acceleration, int suspension, int durability) { //not tested
        Car currentCar = null;

        if ("Show".equals(type)) {
            currentCar = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        } else if ("Performance".equals(type)) {
            currentCar = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        } else {
            return;
        }

        getIdCar().put(id, currentCar);
    }


    public String check(int id) { //not tested
        return this.getIdCar().get(id).toString();
    }


    public void open(int id, String type, int length, String route, int prizePool) {
        Race currentRace = null;

        if ("Drag".equals(type)) {
            currentRace = new DragRace(length, route, prizePool);
        } else if ("Casual".equals(type)) {
            currentRace = new CasualRace(length, route, prizePool);
        } else {
            return;
        }

        this.getIdRace().put(id, currentRace);
    }


    public void participate(int carId, int raceId) {

    }


    public String start(int id) {
        return null;
    }


    public void park(int id) {

    }


    public void unpark(int id) {

    }


    public void tune(int tuneIndex, String addOn) {
        //get the tuneAllCars from the Garage class, or think of a new way of doing the stuff
    }

}
