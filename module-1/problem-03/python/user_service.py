from user_repository import UserRepository

class UserService:
    def __init__(self):
        self.repo = UserRepository()

    def withdraw_money(self, user_id, amount):
        try:
            balance = self.repo.get_balance(user_id)
            if balance < amount:
                raise Exception("Insufficient funds")
            self.repo.update_balance(user_id, -amount)
            print("Withdrawal successful")
        except Exception as e:
            print(f"Error: {e}")
            print("An error occurred while withdrawing money")

    def deposit_money(self, user_id, amount):
        try:
            self.repo.update_balance(user_id, amount)
            print("Deposit successful")
        except Exception as e:
            print(f"Error: {e}")
            print("An error occurred while depositing money")
