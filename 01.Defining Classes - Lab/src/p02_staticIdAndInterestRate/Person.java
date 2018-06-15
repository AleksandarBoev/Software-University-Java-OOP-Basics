package p02_staticIdAndInterestRate;

import java.util.ArrayList;
import java.util.List;

public class Person { // not part of the Judge problem solve. Just experimenting
    private String name;
    private int age;
    private List<BankAccount> bankAccounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> bankAccounts) {
        this.name = name;
        this.age = age;
        this.bankAccounts = bankAccounts;//TODO both are refferant types. Find out how to clone it. And this list is made out of refferant types. Keep that in mind
    }

    public double getTotalBalance() {
        return this.bankAccounts.stream()
                .mapToDouble(bankAccount -> bankAccount.getBalance())
                .sum();
    }

}
