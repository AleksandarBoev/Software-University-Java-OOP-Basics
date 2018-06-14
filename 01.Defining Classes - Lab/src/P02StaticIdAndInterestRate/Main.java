package P02StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount currentAccount = new BankAccount();
                    accounts.put(currentAccount.getId(), currentAccount);

                    System.out.printf("Account %s created%n", currentAccount.toString());
                    break;

                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %s to %s%n", tokens[2], accounts.get(id).toString());
                    }
                    break;

                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterest(newInterest);
                    break;

                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    if (!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        int years = Integer.parseInt(tokens[2]);
                        System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                    }
                    break;
            }
        }
        //main ends here
    }
}
