package p04_shoppingSpree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private static final String NEGATIVE_MONEY_MESSAGE = "Money cannot be negative";
    private static final String INVALID_NAME_MESSAGE = "Name cannot be empty";
    private static final String INSUFFICIENT_MONEY_MESSAGE = "%s can't afford %s";

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    public void setName(String name) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }

        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_MESSAGE);
        }

        this.money = money;
    }

    public void buyProduct(Product product) {
        double price = product.getPrice();

        if (price > this.money) {
            throw new IllegalArgumentException(String.format(INSUFFICIENT_MONEY_MESSAGE, this.name, product.getName()));
        }

        this.money -= price;
        this.products.add(product);
    }

    public String displayBoughtProducts() {
        if (!this.products.isEmpty()) {
            return this.name + " - " + this.products.stream()
                    .map(p -> p.getName())
                    .collect(Collectors.toList())
                    .toString().replaceAll("[\\[\\]]", "");
        } else {
            return this.name + " - " + "Nothing bought";
        }
    }
}
