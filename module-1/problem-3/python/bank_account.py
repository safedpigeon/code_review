class BankAccount:
    def __init__(self, initial_balance):
        self.balance = initial_balance

    def deposit(self, amount):
        if amount <= 0:
            print("Invalid deposit amount")
        else:
            self.balance += amount

    def withdraw(self, amount):
        if amount > self.balance:
            raise Exception("Insufficient funds!")
        if amount <= 0:
            raise Exception("Invalid withdraw amount!")
        self.balance -= amount
        return self.balance

    def get_balance(self):
        return self.balance
