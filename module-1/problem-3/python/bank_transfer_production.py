import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')
logger = logging.getLogger(__name__)

class BankError(Exception):
    """Base exception for bank operations"""
    pass

class InsufficientFundsError(BankError):
    def __init__(self, account_id, amount):
        self.account_id = account_id
        self.amount = amount
        super().__init__(f"Account {account_id} has insufficient funds for transfer of {amount}")

class AccountNotFoundError(BankError):
    def __init__(self, account_id):
        self.account_id = account_id
        super().__init__(f"Account {account_id} was not found in the system")

class BankService:
    def transfer(self, from_acc, to_acc, amount):
        logger.info(f"Initiating transfer of {amount} from {from_acc} to {to_acc}")
        
        self._validate_account(from_acc)
        self._validate_account(to_acc)
        self._check_funds(from_acc, amount)
        
        logger.info(f"Transfer completed successfully from {from_acc} to {to_acc}")

    def _validate_account(self, account_id):
        if account_id == "Unknown":
            raise AccountNotFoundError(account_id)

    def _check_funds(self, account_id, amount):
        if account_id == "Acc1" and amount > 500:
            raise InsufficientFundsError(account_id, amount)

def global_error_handler(func):
    """Decorator to simulate a global exception handler/middleware"""
    def wrapper(*args, **kwargs):
        try:
            return func(*args, **kwargs)
        except BankError as e:
            logger.warning(f"Business Rule Violation: {e}")
        except Exception as e:
            logger.error(f"Unexpected System Error: {e}", exc_info=True)
    return wrapper

@global_error_handler
def run_transfer(service, from_acc, to_acc, amount):
    service.transfer(from_acc, to_acc, amount)

if __name__ == "__main__":
    service = BankService()
    
    test_cases = [
        ("Acc1", "Acc2", 100),
        ("Acc1", "Acc2", 10000),
        ("Acc1", "Unknown", 50),
    ]
    
    for from_acc, to_acc, amount in test_cases:
        run_transfer(service, from_acc, to_acc, amount)
