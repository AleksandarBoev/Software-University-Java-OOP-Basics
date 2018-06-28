package p02_carShopExtended.carInterfaces;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
