from payment_gateway import PaymentGateway

class PaymentService:
    def __init__(self):
        self.gateway = PaymentGateway()

    def process_payment(self, amount, card_number):
        try:
            if amount <= 0:
                raise Exception("Amount must be positive")
            
            success = self.gateway.charge(amount, card_number)
            if success:
                print("Payment processed successfully!")
        except Exception as e:
            # Naive error handling: just printing to console
            print(f"Error processing payment: {e}")
            import traceback
            traceback.print_exc()
