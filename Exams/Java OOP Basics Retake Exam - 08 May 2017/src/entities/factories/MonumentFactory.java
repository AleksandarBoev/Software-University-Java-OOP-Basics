package entities.factories;

import contracts.Factory;
import contracts.Monument;
import entities.monuments.AirMonument;
import entities.monuments.EarthMonument;
import entities.monuments.FireMonument;
import entities.monuments.WaterMonument;

public class MonumentFactory implements Factory<Monument> {
    @Override
    public Monument create(String... args) {
        //Monument Fire JerseyGrew 1000
        String type = args[1];
        String name = args[2];
        int affinity = Integer.parseInt(args[3]);

        switch (type) {
            case "Air":
                return new AirMonument(name, affinity);

            case "Fire":
                return new FireMonument(name, affinity);

            case "Earth":
                return new EarthMonument(name, affinity);

            case "Water":
                return new WaterMonument(name, affinity);

                default:
                    return null;
        }
    }
}
