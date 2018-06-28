package p02_carShopExtended.carImplementations;

import p02_carShopExtended.carInterfaces.Car;

public abstract class BaseCar implements Car {
    private String countryProduced;
    private String model;
    private Integer horsePower;
    private String color;

    public BaseCar(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getCountryMade() {
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
        sb.append(String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryMade(), TIRES));

        return sb.toString();
    }
}
