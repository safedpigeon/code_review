
class PayPalProcessor:
    def process_payment(self, amount: float):
        print(f"Processing payment of ${amount} via PayPal...")
        return True

class PaymentService:
    def __init__(self):
        # TIGHT COUPLING: PaymentService is directly dependent on PayPalProcessor
        self.processor = PayPalProcessor()

    def make_payment(self, amount: float):
        print("PaymentService: Initiating payment process.")
        success = self.processor.process_payment(amount)
        if success:
            print("PaymentService: Payment completed successfully.")
        else:
            print("PaymentService: Payment failed.")

if __name__ == "__main__":
    service = PaymentService()
    service.make_payment(100.0)
