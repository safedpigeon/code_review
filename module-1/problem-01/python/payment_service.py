class PaymentService:
    def process_payment(self, credit_card_details):
        print(f"Connecting to Payment Gateway for card {credit_card_details['number']}...")
        # Simulate payment API call
        payment_success = True 
        if not payment_success:
            raise Exception("Payment failed!")
        print("Payment processed successfully.")
