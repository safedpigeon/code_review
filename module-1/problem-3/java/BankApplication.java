package module1.problem3;

import java.util.logging.Logger;
import java.util.logging.Level;

public class BankApplication {
    private static final Logger logger = Logger.getLogger(BankApplication.class.getName());

    public static void main(String[] args) {
        BankService bankService = new BankService();

        String[][] testCases = {
            {"Acc1", "Acc2", "100"},
            {"Acc1", "Acc2", "10000"},
            {"Acc1", "Unknown", "50"}
        };

        for (String[] testCase : testCases) {
            try {
                bankService.transfer(testCase[0], testCase[1], Double.parseDouble(testCase[2]));
            } catch (BankException e) {
                handleBankException(e);
            } catch (Exception e) {
                handleUnexpectedException(e);
            }
        }
    }

    private static void handleBankException(BankException e) {
        // In a real app, this would return a specific HTTP status code or Error Response object
        logger.log(Level.WARNING, "Business Rule Violation: {0}", e.getMessage());
    }

    private static void handleUnexpectedException(Exception e) {
        logger.log(Level.SEVERE, "Unexpected System Error: {0}", e.getMessage(), e);
    }
}
