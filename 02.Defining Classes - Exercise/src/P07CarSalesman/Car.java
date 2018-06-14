package P07CarSalesman;

import javafx.util.Pair;

import java.text.DecimalFormat;

public class Car {//a model, engine, weight(o) and color(o)
    private String model;
    private Pair<String, Engine> engine;
    private Integer weight;
    private String color;

    public Car(String model, Pair<String, Engine> engine) {
        this.model = model;
        this.engine = engine;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String handleNullInteger(Integer number) {
        if (number == null) {
            return "n/a";
        } else {
            return number.toString();
        }
    }

    private String handleNullString(String text) {
        if (text == null) {
            return "n/a";
        } else {
            return text;
        }
    }

    //<CarModel>:
    //<EngineModel>:
    //Power: <EnginePower>
    //Displacement: <EngineDisplacement>
    //Efficiency: <EngineEfficiency>
    //Weight: <CarWeight>
    //Color: <CarColor>
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine.getKey()).append(":").append(System.lineSeparator());
        sb.append(String.format("Power: %s%n", this.engine.getValue().getPower()));

        sb.append(String.format("Displacement: %s%n", handleNullInteger(this.engine.getValue().getDisplacement())));
        sb.append(String.format("Efficiency: %s%n", handleNullString(this.engine.getValue().getEfficiency())));
        sb.append(String.format("Weight: %s%n", handleNullInteger(this.weight)));
        sb.append(String.format("Color: %s", handleNullString(this.color)));

        return sb.toString();
    }
}
