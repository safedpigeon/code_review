import time

class SharedAccount:
    """
    SharedAccount demonstrates a basic bank account implementation.
    
    This version is intended to be functional for single-threaded use 
    but exhibits common concurrency issues when accessed by multiple threads.
    """
    def __init__(self):
        self.balance = 0

    def deposit(self, amount):
        current_balance = self.balance
        # Simulate some processing time to increase the chance of race condition
        time.sleep(0.001)
        self.balance = current_balance + amount

    def withdraw(self, amount):
        current_balance = self.balance
        # Simulate some processing time to increase the chance of race condition
        time.sleep(0.001)
        self.balance = current_balance - amount

    def get_balance(self):
        return self.balance
