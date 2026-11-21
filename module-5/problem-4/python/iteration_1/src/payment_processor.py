import random

class PaymentProcessor:
    def process_payment(self, amount, currency, region, user_type):
        if amount <= 0:
            raise ValueError("Amount must be positive")
        if currency is None:
            raise ValueError("Currency cannot be null")

        tax_rate = 0.05
        if region.upper() == "US":
            tax_rate = 0.10
        elif region.upper() == "EU":
            tax_rate = 0.20

        discount = 0.0
        if user_type.upper() == "PREMIUM":
            discount = 0.10
        elif user_type.upper() == "GOLD":
            discount = 0.20

        final_amount = amount + (amount * tax_rate) - (amount * discount)
        
        print(f"Processing payment of {final_amount} {currency} for region {region}")
        
        # Simulating a database call or external API call
        if random.random() < 0.01:
            raise RuntimeError("Network error occurred during payment processing")

        return final_amount

if __name__ == "__main__":
    processor = PaymentProcessor()
    print(f"Result: {processor.process_payment(100.0, 'USD', 'US', 'GOLD')}")
