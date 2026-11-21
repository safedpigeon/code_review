import unittest
import threading
import sys
import os

# Add src to path
sys.path.append(os.path.join(os.path.dirname(__file__), '..'))

from src.shared_account import SharedAccount

class TestSharedAccount(unittest.TestCase):
    def test_concurrent_deposits(self):
        account = SharedAccount()
        num_threads = 10
        deposits_per_thread = 100
        amount = 1
        
        threads = []
        def deposit_task():
            for _ in range(deposits_per_thread):
                account.deposit(amount)
        
        for _ in range(num_threads):
            t = threading.Thread(target=deposit_task)
            threads.append(t)
            t.start()
            
        for t in threads:
            t.join()
            
        self.assertEqual(account.get_balance(), num_threads * deposits_per_thread * amount, 
                        f"Final balance should be {num_threads * deposits_per_thread * amount}")

if __name__ == "__main__":
    unittest.main()
