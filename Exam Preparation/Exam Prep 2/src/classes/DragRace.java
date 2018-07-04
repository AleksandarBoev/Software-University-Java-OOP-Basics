package classes;

import abstractClasses.Car;
import abstractClasses.Race;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Integer calculatePerformancePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration());
    }
}
