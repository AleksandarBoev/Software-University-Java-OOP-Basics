package p01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // {Car {fuel quantity} {liters per km}}
        // {Truck {fuel quantity} {liters per km}}
        String[] carTokens = reader.readLine().split(" ");
        Car car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String[] truckTokens = reader.readLine().split(" ");
        Car truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] currentTokens = reader.readLine().split(" ");

            String command = currentTokens[0];
            String vehicle = currentTokens[1];
            double distanceOrFuel = Double.parseDouble(currentTokens[2]);

            Car currentVehicle = null;
            if ("Car".equalsIgnoreCase(vehicle)) {
                currentVehicle = car;
            } else if ("Truck".equalsIgnoreCase(vehicle)) {
                currentVehicle = truck;
            }

            if ("Drive".equalsIgnoreCase(command)) {
                currentVehicle.travel(distanceOrFuel);
            } else if ("Refuel".equalsIgnoreCase(command)) {
                currentVehicle.refuel(distanceOrFuel);
            }
        }

        System.out.println(car);
        System.out.println(truck);
        //main ends here
    }
}
