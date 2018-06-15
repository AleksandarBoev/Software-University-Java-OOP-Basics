package p07_carSalesman;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> modelEngine = new HashMap<>();

        int numberOfEngines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfEngines; i++) {
            //“<Model> <Power> <Displacement> <Efficiency>
            String[] engineTokens = reader.readLine().split(" ");

            String engineModel = engineTokens[0];
            Integer enginePower = Integer.valueOf((engineTokens[1]));
            Engine currentEngine = new Engine(engineModel, enginePower);

            if (engineTokens.length == 3) {
                try {
                    currentEngine.setDisplacement(Integer.valueOf((engineTokens[2])));
                } catch (NumberFormatException nfe) {
                    currentEngine.setEfficiency(engineTokens[2]);
                }
            } else if (engineTokens.length == 4) {
                currentEngine.setDisplacement(Integer.valueOf((engineTokens[2])));
                currentEngine.setEfficiency(engineTokens[3]);
            }

            modelEngine.put(engineModel, currentEngine);
        }


        int numberOfCars = Integer.parseInt(reader.readLine());
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            //“<Model> <Engine> <Weight> <Color>”, where the engine in the format will be the model of an existing Engine
            String[] carTokens = reader.readLine().split(" ");
            String carModel = carTokens[0];

            String engineModel = carTokens[1];
            Pair<String, Engine> engine = new Pair<>(engineModel, modelEngine.get(engineModel));

            Car currentCar = new Car(carModel, engine);

            if (carTokens.length == 3) {
                try {
                    currentCar.setWeight(Integer.valueOf(carTokens[2]));
                } catch (NumberFormatException nfe) {
                    currentCar.setColor(carTokens[2]);
                }
            } else if (carTokens.length == 4) {
                currentCar.setWeight(Integer.valueOf(carTokens[2]));
                currentCar.setColor(carTokens[3]);
            }

            cars[i] = currentCar;
        }

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        //main ends here
    }
}
