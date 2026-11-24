import random
from .payment_gateway import PaymentGateway

class PaymentGatewayImpl(PaymentGateway):
    def process(self, amount, currency):
        print(f"Sending request to bank for {amount} {currency}")
        if random.random() < 0.01:
            raise RuntimeError("Network error occurred during payment processing")
