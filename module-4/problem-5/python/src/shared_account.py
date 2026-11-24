import time
import threading

class SharedAccount:
    """
    SharedAccount demonstrates a thread-safe bank account implementation.
    
    This implementation resolves the race conditions identified in Iteration 1
    by using a threading.Lock. This ensures that operations on the shared
    balance are atomic, preventing lost updates in concurrent environments.
    """
    def __init__(self):
        self.balance = 0
        self._lock = threading.Lock()

    def deposit(self, amount):
        with self._lock:
            current_balance = self.balance
            # Simulate some processing time to increase the chance of race condition
            time.sleep(0.001)
            self.balance = current_balance + amount

    def withdraw(self, amount):
        with self._lock:
            current_balance = self.balance
            # Simulate some processing time to increase the chance of race condition
            time.sleep(0.001)
            self.balance = current_balance - amount

    def get_balance(self):
        with self._lock:
            return self.balance
