package p01_vehicles_abstractVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //test input:
        //Car 15 0.3
        //Truck 100 0.9
        //4
        //Drive Car 9
        //Drive Car 30
        //Refuel Car 50
        //Drive Truck 10

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String[] truckTokens = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");

            String command = tokens[0];
            String vehicleType = tokens[1];

            Vehicle currentVehicle = null;
            if ("Car".equalsIgnoreCase(vehicleType)) {
                currentVehicle = car;
            } else {
                currentVehicle = truck;
            }

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(currentVehicle.getTravelResult(distance));
                    break;

                case "Refuel":
                    double amount = Double.parseDouble(tokens[2]);
                    currentVehicle.refuel(amount);
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        //main ends here
    }
}
