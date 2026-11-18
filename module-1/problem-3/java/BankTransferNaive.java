public class BankTransferNaive {
    public static void main(String[] args) {
        BankTransferNaive bank = new BankTransferNaive();
        
        // Case 1: Success
        bank.transfer("Acc1", "Acc2", 100);
        
        // Case 2: Insufficient funds
        bank.transfer("Acc1", "Acc2", 10000);
        
        // Case 3: Non-existent account
        bank.transfer("Acc1", "Unknown", 50);
    }

    public void transfer(String from, String to, double amount) {
        try {
            System.out.println("Transferring " + amount + " from " + from + " to " + to + "...");
            
            if (from.equals("Acc1") && amount > 500) {
                throw new Exception("Insufficient funds!");
            }
            
            if (to.equals("Unknown")) {
                throw new Exception("Account not found!");
            }
            
            System.out.println("Transfer successful!");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
