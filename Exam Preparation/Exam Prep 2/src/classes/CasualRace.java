package classes;

import abstractClasses.Car;
import abstractClasses.Race;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Integer calculatePerformancePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }
}
