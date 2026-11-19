class UserRepository:
    def __init__(self):
        self.accounts = {1: 100.0, 2: 50.0}

    def get_balance(self, user_id):
        if user_id not in self.accounts:
            raise Exception("User not found")
        return self.accounts[user_id]

    def update_balance(self, user_id, amount):
        if user_id not in self.accounts:
            raise Exception("User not found")
        self.accounts[user_id] += amount
