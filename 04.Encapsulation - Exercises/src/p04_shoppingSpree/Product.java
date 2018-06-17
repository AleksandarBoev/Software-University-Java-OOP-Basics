package p04_shoppingSpree;

public class Product {
    private static final String INVALID_PRODUCT_NAME_MESSAGE = "Name cannot be empty";
    private static final String NEGATIVE_MONEY_MESSAGE = "Money cannot be negative";

    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException(INVALID_PRODUCT_NAME_MESSAGE);
        }

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_MESSAGE);
        }

        this.price = price;
    }
}
