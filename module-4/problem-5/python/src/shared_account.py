import time
import threading

class SharedAccount:
    """
    SharedAccount demonstrates a classic concurrency problem: Race Conditions.
    
    The original implementation was not thread-safe, meaning if multiple threads
    tried to deposit or withdraw simultaneously, some updates would be lost
    because the read-modify-write cycle was not atomic.
    
    The fix uses a threading.Lock to ensure that only one thread can execute
    the critical section of the deposit and withdraw methods at a time,
    making the operations atomic.
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
