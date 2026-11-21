
from abc import ABC, abstractmethod

class PaymentProcessor(ABC):
    @abstractmethod
    def process_payment(self, amount: float) -> bool:
        pass

class PayPalProcessor(PaymentProcessor):
    def process_payment(self, amount: float) -> bool:
        print(f"Processing payment of ${amount} via PayPal...")
        return True

class StripeProcessor(PaymentProcessor):
    def process_payment(self, amount: float) -> bool:
        print(f"Processing payment of ${amount} via Stripe...")
        return True

class PaymentService:
    def __init__(self, processor: PaymentProcessor):
        # LOOSE COUPLING: PaymentService depends on the abstraction, not a concrete class
        self.processor = processor

    def make_payment(self, amount: float):
        print("PaymentService: Initiating payment process.")
        success = self.processor.process_payment(amount)
        if success:
            print("PaymentService: Payment completed successfully.")
        else:
            print("PaymentService: Payment failed.")

if __name__ == "__main__":
    # We can now inject any processor we want
    paypal_service = PaymentService(PayPalProcessor())
    paypal_service.make_payment(100.0)

    stripe_service = PaymentService(StripeProcessor())
    stripe_service.make_payment(200.0)
