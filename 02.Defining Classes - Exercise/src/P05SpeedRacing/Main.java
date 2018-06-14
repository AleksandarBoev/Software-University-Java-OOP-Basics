package P05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(reader.readLine());
        Map<String, Car> modelCar = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            //you will receive information for a car in the following format “<Model> <FuelAmount> <FuelCostFor1km>”, all cars start at 0 kilometers traveled.
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            Double fuelAmount = Double.parseDouble(tokens[1]);
            Double fuelCostPerKilometer = Double.parseDouble(tokens[2]);

            Car currentCar = new Car(model, fuelAmount, fuelCostPerKilometer);
            modelCar.put(model, currentCar);
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            //you will receive a commands in the following format “Drive <CarModel>  <amountOfKm>”
            String[] tokens = input.split(" ");

            String model = tokens[1];
            Double distance = Double.parseDouble(tokens[2]);

            if (!modelCar.get(model).canTravelDistance(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        reader.close();

        for (Car car : modelCar.values()) {
            System.out.println(car);
        }

        //main ends here
    }
}
