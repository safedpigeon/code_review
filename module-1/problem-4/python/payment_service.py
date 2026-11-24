class PaymentService:
    def __init__(self, config):
        self.config = config

    def process_payment(self, amount):
        # Use externalized configuration
        print(f"Connecting to {self.config.api_url} with key {self.config.api_key}")
        print(f"Processing payment of ${amount} with timeout {self.config.timeout}ms")
        print("Payment processed successfully.")
