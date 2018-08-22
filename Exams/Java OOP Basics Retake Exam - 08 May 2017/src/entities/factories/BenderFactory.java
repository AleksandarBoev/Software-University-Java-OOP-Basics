package entities.factories;

import contracts.Bender;
import contracts.Factory;
import entities.benders.AirBender;
import entities.benders.EarthBender;
import entities.benders.FireBender;
import entities.benders.WaterBender;

public class BenderFactory implements Factory<Bender> {
    @Override
    public Bender create(String... args) {
        //Bender Fire Tony 1000 2500.5667

        String type = args[1];
        String name = args[2];
        int power = Integer.parseInt(args[3]);
        double additionalSkill = Double.parseDouble(args[4]);

        switch (type) {
            case "Air":
                return new AirBender(name, power, additionalSkill);

            case "Water":
                return new WaterBender(name, power, additionalSkill);

            case "Fire":
                return new FireBender(name, power, additionalSkill);

            case "Earth":
                return new EarthBender(name, power, additionalSkill);

            default:
                return null;
        }
    }
}
