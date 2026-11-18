public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        try {
            account.deposit(50);
            System.out.println("Balance after deposit: " + account.getBalance());

            account.withdraw(200);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.withdraw(-10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
