package p02_vehicleExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));

        String[] truckTokens = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));

        String[] busTokens = reader.readLine().split(" ");
        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(" ");

            String command = tokens[0];
            String vehicleType = tokens[1];

            Vehicle currentVehicle = null;

            switch (vehicleType) {
                case "Car":
                    currentVehicle = car;
                    break;

                case "Truck":
                    currentVehicle = truck;
                    break;

                case "Bus":
                    currentVehicle = bus;
                    break;
            }

            try {
                switch (command) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        System.out.println(currentVehicle.getTravelResultWithAirConditionerOn(distance)); // Intellij saying it could produce null, but the task says the vehicle type will be one of three
                        break;

                    case "Refuel":
                        double amount = Double.parseDouble(tokens[2]);
                        currentVehicle.refuel(amount);
                        break;

                    case "DriveEmpty":
                        distance = Double.parseDouble(tokens[2]);
                        System.out.println(currentVehicle.getTravelResult(distance));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
        //main ends here
    }
}
