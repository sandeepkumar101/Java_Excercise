public class BankAccount {

    private String owner;
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double dollars) {
        this.balance = this.balance + dollars;
    }

    public boolean withdraw(double dollars) {
        if (this.balance < dollars) {
            System.out.println("ERROR: Not enough money in balance");
            return false;
        } else {
            this.balance = this.balance - dollars;
            return true;
        }
    }

    void setBalance(double dollars) {
        this.balance = dollars;
    }

    void transfer(BankAccount other, double amount) {
        if (withdraw(amount)) {
            other.balance = other.balance + amount;
        }
    }
}