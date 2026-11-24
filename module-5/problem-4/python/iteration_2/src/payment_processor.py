from .services.tax_calculator import TaxCalculator
from .services.discount_calculator import DiscountCalculator
from .gateways.payment_gateway_impl import PaymentGatewayImpl

class PaymentProcessor:
    def __init__(self, tax_calculator, discount_calculator, payment_gateway):
        self.tax_calculator = tax_calculator
        self.discount_calculator = discount_calculator
        self.payment_gateway = payment_gateway

    def process_payment(self, amount, currency, region, user_type):
        if amount <= 0:
            raise ValueError("Amount must be positive")
        if currency is None:
            raise ValueError("Currency cannot be null")

        tax = self.tax_calculator.calculate_tax(amount, region)
        discount = self.discount_calculator.calculate_discount(amount, user_type)

        final_amount = amount + tax - discount
        
        print(f"Processing payment of {final_amount} {currency} for region {region}")
        
        self.payment_gateway.process(final_amount, currency)

        return final_amount

if __name__ == "__main__":
    # For simple execution, we instantiate the real components
    from .services.tax_calculator import TaxCalculator
    from .services.discount_calculator import DiscountCalculator
    from .gateways.payment_gateway_impl import PaymentGatewayImpl
    
    processor = PaymentProcessor(
        TaxCalculator(),
        DiscountCalculator(),
        PaymentGatewayImpl()
    )
    try:
        print(f"Result: {processor.process_payment(100.0, 'USD', 'US', 'GOLD')}")
    except Exception as e:
        print(f"Error: {e}")
