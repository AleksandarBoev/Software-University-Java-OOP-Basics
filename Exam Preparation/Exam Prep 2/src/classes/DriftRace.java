package classes;

import abstractClasses.Car;
import abstractClasses.Race;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Integer calculatePerformancePoints(Car car) {
        return (car.getSuspension() + car.getDurability());
    }
}
