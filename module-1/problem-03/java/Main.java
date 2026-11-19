public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        
        // Success
        service.depositMoney(1, 50.0);
        service.withdrawMoney(1, 20.0);
        
        // Fail: Insufficient funds
        service.withdrawMoney(2, 100.0);
        
        // Fail: User not found
        service.withdrawMoney(99, 10.0);
    }
}
