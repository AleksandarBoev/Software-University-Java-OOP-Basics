package p04_shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> namePerson = new LinkedHashMap<>();

        String[] peopleTokens = reader.readLine().split(";");
        for (int i = 0; i < peopleTokens.length; i++) {
            String personName = peopleTokens[i].split("=")[0];
            double personMoney = Double.parseDouble(peopleTokens[i].split("=")[1]);

            try {
                Person person = new Person(personName, personMoney);
                namePerson.put(personName, person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        Map<String, Product> nameProduct = new LinkedHashMap<>();

        String[] productsTokens = reader.readLine().split(";");
        for (int i = 0; i < productsTokens.length; i++) {
            String productName = productsTokens[i].split("=")[0];
            double productPrice = Double.parseDouble(productsTokens[i].split("=")[1]);

            try {
                Product product = new Product(productName, productPrice);
                nameProduct.put(productName, product);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        String input;
        while(!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" "); // a name could be made from firstName and lastName

            String productName = tokens[tokens.length - 1]; // last word is the product,
            String personName = input.replace(productName, "").trim(); //and everything before that is the name of the person

            if (!namePerson.containsKey(personName) || !nameProduct.containsKey(productName)) {
                continue;
            }

            try {
                namePerson.get(personName).buyProduct(nameProduct.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (Person person : namePerson.values()) {
            System.out.println(person.displayBoughtProducts());
        }

        //main ends here
    }
}
