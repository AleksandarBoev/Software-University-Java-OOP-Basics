package p01_carShop;

public class Seat implements Car {
    private String countryProduced;
    private String model;
    private Integer horsePower;
    private String color;

    public Seat(String countryProduced, String model, Integer horsePower, String color) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.horsePower = horsePower;
        this.color = color;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s is %s and have %d horse power", this.getModel(), this.getColor(), this.getHorsePower()));
        sb.append(System.lineSeparator());
        sb.append(String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryProduced(), TIRES));

        return sb.toString();
    }
}
