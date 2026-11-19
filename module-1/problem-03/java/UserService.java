public class UserService {
    private UserRepository repo = new UserRepository();

    public void withdrawMoney(int id, double amount) {
        try {
            Double balance = repo.getBalance(id);
            if (balance < amount) {
                throw new Exception("Insufficient funds");
            }
            repo.updateBalance(id, -amount);
            System.out.println("Withdrawal successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while withdrawing money");
        }
    }

    public void depositMoney(int id, double amount) {
        try {
            repo.updateBalance(id, amount);
            System.out.println("Deposit successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while depositing money");
        }
    }
}
