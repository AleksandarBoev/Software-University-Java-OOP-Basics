package p02_carShopExtended;

import p02_carShopExtended.carImplementations.Audi;
import p02_carShopExtended.carImplementations.Seat;
import p02_carShopExtended.carInterfaces.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { // this task looks like it needs only abstraction classes, and not interfaces, but whatever...
        List<Car> cars = new ArrayList<>();

        Seat seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Audi audi = new Audi("Leon", "Gray", 110, "Spain", 3, 99.9);

        cars.add(seat);
        cars.add(audi);

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
