package engine;

import abstractClasses.Car;
import abstractClasses.Race;
import classes.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> idCar;
    private Map<Integer, Race> idRace;
    private Garage garage;

    public CarManager() {
        this.idCar = new LinkedHashMap<>();
        this.idRace = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    private Map<Integer, Car> getIdCar() {
        return this.idCar;
    }

    private Map<Integer, Race> getIdRace() {
        return this.idRace;
    }

    private Garage getGarage() {
        return this.garage;
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
        } else if ("Drift".equals(type)) {
            currentRace = new DriftRace(length, route, prizePool);
        }

        this.getIdRace().put(id, currentRace);
    }

//TODO so a car CAN participate(be in a race which has not yet been held) in many races, but it can't be parked somewhere while it participates even in a SINGLE race
    public void participate(int carId, int raceId) {
        Car currentCar = this.getIdCar().get(carId);
        if (this.carIsInGarage(currentCar)) {
            return;
        }

        Race currentRace = this.getIdRace().get(raceId);

        currentRace.getParticipants().add(currentCar);
    }


    public String start(int id) {
        //has to return a String representaion of the results of a race with {id} and remove the race from the list (i think
        // A race CANNOT start without ANY participants.)
        //o	INITIATES the race with the given id.
        //o	RETURNS detailed information about the race result.
        //return this string:
//o	“{route} - {length}
//o	 1. {brand} {model} {performancePoints}PP - ${moneyWon}
//o	 2. {brand} {model} {performancePoints}PP - ${moneyWon}
//o	 3. {brand} {model} {performancePoints}PP - ${moneyWon}”
        //When you START a race, the winners are calculated immediately, PRINTED as output,
        // and the race becomes CLOSED (you CANNOT add any more participants in it, and you CANNOT start it again).
        Race currentRace = this.getIdRace().get(id);
        if (currentRace.getParticipants().isEmpty()) {
            return null;
        }

        currentRace.sortParticipants();
        int[] prizes = currentRace.getPrizes();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", currentRace.getRoute(), currentRace.getLength())).append(System.lineSeparator());
        int counter = 1;
        for (Car car : currentRace.getParticipants()) {
            if (counter > 3) {
                break;
            }

            //1. Trabant 601 3000PP - $25000
            sb.append(String.format("%d. %s %s %dPP - $%d", counter, car.getBrand(), car.getModel(),
                    currentRace.calculatePerformancePoints(car), prizes[counter - 1])).append("\n");

            counter++;
        }

        sb.delete(sb.length() - 1, sb.length()); //delete last new line

        return sb.toString();
    }


    public void park(int id) {
        Car currentCar = this.getIdCar().get(id);
        if (this.carParticipatesInAtleastOneRace(currentCar)) {
            return;
        }

        this.getGarage().getParkedCars().add(currentCar);
    }


    public void unpark(int id) {
        Car currentCar = this.getIdCar().get(id);

        this.getGarage().getParkedCars().remove(currentCar);
    }


    public void tune(int tuneIndex, String addOn) {
        //get the tuneAllCars from the Garage class, or think of a new way of doing the stuff
        this.getGarage().tuneAllCars(tuneIndex, addOn);
    }


    private boolean carParticipatesInAtleastOneRace(Car car) {
        for (Race race : this.idRace.values()) { //search in every race if it contains such a car
            if (race.getParticipants().contains(car)) {
                return true;
            }
        }

        return false;
    }

    private boolean carIsInGarage(Car car) {
        return this.getGarage().getParkedCars().contains(car);
    }
}
