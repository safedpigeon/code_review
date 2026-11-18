package module1.problem3;

import java.util.logging.Logger;
import java.util.logging.Level;

public class BankService {
    private static final Logger logger = Logger.getLogger(BankService.class.getName());

    public void transfer(String from, String to, double amount) {
        logger.info("Initiating transfer of " + amount + " from " + from + " to " + to);

        validateAccount(from);
        validateAccount(to);
        checkFunds(from, amount);

        // Perform transfer logic here
        logger.info("Transfer completed successfully from " + from + " to " + to);
    }

    private void validateAccount(String accountId) {
        if ("Unknown".equals(accountId)) {
            throw new AccountNotFoundException(accountId);
        }
    }

    private void checkFunds(String accountId, double amount) {
        if ("Acc1".equals(accountId) && amount > 500) {
            throw new InsufficientFundsException(accountId, amount);
        }
    }
}
