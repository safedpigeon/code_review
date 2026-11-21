from customer import Customer
from pricing_policy import PricingPolicy

class Invoice:
    def calculate_discount(self, customer: Customer, policy: PricingPolicy):
        discount = policy.base_discount
        
        # Feature Envy: Invoice is too interested in Customer's details
        if customer.membership_level == "GOLD":
            discount += 0.10
        elif customer.membership_level == "SILVER":
            discount += 0.05
            
        if customer.years_as_customer > 5:
            discount += policy.loyalty_multiplier * 0.02
            
        return discount
