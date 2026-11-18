package module1.problem3;

public class BankException extends RuntimeException {
    public BankException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends BankException {
    public InsufficientFundsException(String accountId, double amount) {
        super("Account " + accountId + " has insufficient funds for transfer of " + amount);
    }
}

class AccountNotFoundException extends BankException {
    public AccountNotFoundException(String accountId) {
        super("Account " + accountId + " was not found in the system");
    }
}
