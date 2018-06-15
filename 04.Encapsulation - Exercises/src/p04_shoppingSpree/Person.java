package p04_shoppingSpree;

import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public void setName(String name) {
        if ("".equals(name) || name.matches("\\s+")) {
            throw new IllegalArgumentException("This name sux");
        }

        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money is less than 0");
        }

        this.money = money;
    }

    public void buyProduct(Product product) {//TODO where do I make the validation?
        double price = product.getCost();

        if (price > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s.", this.name, product.getName()));
        }

        this.money -= price;
    }
}
