import random

class PaymentGateway:
    def charge(self, amount, card_number):
        # Simulate some failures
        if not card_number:
            raise Exception("Invalid card number")
        
        if amount > 10000:
            raise Exception("Amount too high for this gateway")
        
        if random.random() > 0.8:
            raise Exception("Network timeout")
            
        return True
