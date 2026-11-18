public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance += amount;
        }
    }

    public double withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds!");
        }
        if (amount <= 0) {
            throw new Exception("Invalid withdraw amount!");
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}
