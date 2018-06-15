package p06_rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(reader.readLine());
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            //“<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age>
            // <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>”
            String[] tokens = reader.readLine().split(" ");

            String model = tokens[0];

            Integer engineSpeed = Integer.parseInt(tokens[1]);
            Integer enginePower = Integer.parseInt(tokens[2]);

            Integer cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Double tire1Pressure = Double.parseDouble(tokens[5]);
            Integer tire1Age = Integer.parseInt(tokens[6]);

            Double tire2Pressure = Double.parseDouble(tokens[7]);
            Integer tire2Age = Integer.parseInt(tokens[8]);

            Double tire3Pressure = Double.parseDouble(tokens[9]);
            Integer tire3Age = Integer.parseInt(tokens[10]);

            Double tire4Pressure = Double.parseDouble(tokens[11]);
            Integer tire4Age = Integer.parseInt(tokens[12]);

            cars[i] = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age,
                    tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
        }

        String typeOfCargo = reader.readLine();
        if ("fragile".equals(typeOfCargo)) {
            Arrays.stream(cars)
                    .filter(c -> "fragile".equals(c.getCargoType()))
                    .filter(c -> c.atLeastOneTireWithLowerPressure(1.0))
                    .forEach(c -> {
                        System.out.println(c.getModel());
                    });
        } else if ("flamable".equals(typeOfCargo)){
            Arrays.stream(cars)
                    .filter(c -> "flamable".equals(c.getCargoType()))
                    .filter(c -> c.getEnginePower() > 250)
                    .forEach(c -> {
                        System.out.println(c.getModel());
                    });
        }

        reader.close();

        //main ends here
    }
}
