package P01BankAccountTestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] commandTokens = input.split(" ");

            String command = commandTokens[0];
            int currentId = Integer.parseInt(commandTokens[1]);
            boolean accountAlreadyExists = accounts.containsKey(currentId);

            switch (command) {
                case "Create":
                    if (accountAlreadyExists) {
                        System.out.println("Account already exists");
                    } else {
                        BankAccount bankAccount = new BankAccount(); // would be better to make a new constructor, which needs an Id, but this is ok too
                        bankAccount.setId(currentId);
                        accounts.put(currentId, bankAccount);
                    }
                    break;

                case "Deposit":
                    if (!accountAlreadyExists) {
                        System.out.println("Account does not exist");
                    } else {
                        double amount = Double.parseDouble(commandTokens[2]);
                        accounts.get(currentId).deposit(amount);
                    }
                    break;

                case "Withdraw":
                    if (!accountAlreadyExists) {
                        System.out.println("Account does not exist");
                    } else {
                        double amount = Double.parseDouble(commandTokens[2]);
                        if (!accounts.get(currentId).withdraw(amount)) {
                            System.out.println("Insufficient balance");
                        }
                    }
                    break;

                case "Print":
                    if (!accountAlreadyExists) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(accounts.get(currentId));
                    }
                    break;

            }
        }

        //main ends here
    }
}
