package p02_carShopExtended.carImplementations;

import p02_carShopExtended.carInterfaces.Rentable;
import p02_carShopExtended.carInterfaces.Sellable;

public class Seat extends BaseCar implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return this.price;
    }
}
