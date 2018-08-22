package entities.managers;

import contracts.*;
import entities.nations.AirNation;
import entities.nations.EarthNation;
import entities.nations.FireNation;
import entities.nations.WaterNation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvatarManager implements Manager {
    private Nation airNation;
    private Nation fireNation;
    private Nation waterNation;
    private Nation earthNation;

    private Factory<Bender> benderFactory;
    private Factory<Monument> monumentFactory;

    private List<String> wars;

    public AvatarManager(Factory<Bender> benderFactory, Factory<Monument> monumentFactory) {
        this.airNation = new AirNation();
        this.fireNation = new FireNation();
        this.waterNation = new WaterNation();
        this.earthNation = new EarthNation();

        this.benderFactory = benderFactory;
        this.monumentFactory = monumentFactory;

        this.wars = new ArrayList<>();
    }

    @Override
    public void bender(String... args) {
        String type = args[1];
        Bender bender = this.benderFactory.create(args);
        switch (type) {
            case "Air":
                this.airNation.addBender(bender);
                break;

            case "Fire":
                this.fireNation.addBender(bender);
                break;

            case "Water":
                this.waterNation.addBender(bender);
                break;

            case "Earth":
                this.earthNation.addBender(bender);
                break;

        }
    }

    @Override
    public void monument(String... args) {
        String type = args[1];
        Monument monument = this.monumentFactory.create(args);
        switch (type) {
            case "Air":
                this.airNation.addMonument(monument);
                break;

            case "Fire":
                this.fireNation.addMonument(monument);

                break;

            case "Water":
                this.waterNation.addMonument(monument);

                break;

            case "Earth":
                this.earthNation.addMonument(monument);
                break;

        }
    }

    @Override
    public String status(String... args) {
        String type = args[1];

        switch (type) {
            case "Air":
                return this.airNation.toString();

            case "Fire":
                return this.fireNation.toString();

            case "Water":
                return this.waterNation.toString();

            case "Earth":
                return this.earthNation.toString();

            default:
                return null;
        }
    }

    @Override
    public void war(String... args) {
        this.wars.add(String.format("War %d issued by %s", this.wars.size() + 1, args[1]));

        Nation[] nations = new Nation[4];
        nations[0] = this.fireNation;
        nations[1] = this.airNation;
        nations[2] = this.earthNation;
        nations[3] = this.waterNation;

        //strongest nation is going to be the first element in the array
        nations = Arrays.stream(nations).
                sorted((n1, n2) -> {
                    return Double.compare(n2.getTotalPower(), n1.getTotalPower());
                }).toArray(n -> new Nation[n]);

        for (int i = 1; i < nations.length; i++) { //wipe out every other nation except the strongest one
            nations[i].getWipedOut();
        }
    }

    @Override
    public String quit() {
        return String.join(System.lineSeparator(), this.wars);
    }
}
