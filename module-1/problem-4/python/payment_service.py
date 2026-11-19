class PaymentService:
    def __init__(self):
        # Hardcoded configurations - Anti-pattern
        self.API_URL = "https://api.payments.com/v1"
        self.API_KEY = "sk_test_4eC39HqLyjWDarjtT1zdp7dc"
        self.TIMEOUT = 5000

    def process_payment(self, amount):
        print(f"Connecting to {self.API_URL} with key {self.API_KEY}")
        print(f"Processing payment of ${amount} with timeout {self.TIMEOUT}ms")
        # Imagine payment processing logic here
        print("Payment processed successfully.")

if __name__ == "__main__":
    service = PaymentService()
    service.process_payment(250.0)
