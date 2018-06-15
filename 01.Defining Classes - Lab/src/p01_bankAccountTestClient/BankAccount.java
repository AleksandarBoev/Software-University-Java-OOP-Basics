package p01_bankAccountTestClient;

public class BankAccount {
    private int id;
    private double balance;

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

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.getId(), this.getBalance());
    }
}
