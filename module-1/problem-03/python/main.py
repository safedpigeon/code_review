from user_service import UserService

if __name__ == "__main__":
    service = UserService()
    
    # Success
    service.deposit_money(1, 50.0)
    service.withdraw_money(1, 20.0)
    
    # Fail: Insufficient funds
    service.withdraw_money(2, 100.0)
    
    # Fail: User not found
    service.withdraw_money(99, 10.0)
