package P02StaticIdAndInterestRate;

public class BankAccount {
    private int id;
    private static int bankAccountsCount;
    private double balance;

    private final static double DEFAULT_INTEREST = 0.02;
    private static double interestRate = DEFAULT_INTEREST;

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public BankAccount() {
        this(0.0);
    }

    public BankAccount(double balance) {
        this.id = ++bankAccountsCount; //first one will be 1
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0)
            return false;

        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance)
            return false;

        this.balance -= amount;
        return true;
    }

    public static void setInterest(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    @Override
    public String toString() {
        return String.format("ID%d", this.getId());
    }
}
