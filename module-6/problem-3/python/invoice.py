from customer import Customer
from pricing_policy import PricingPolicy

class Invoice:
    def calculate_discount(self, customer: Customer, policy: PricingPolicy):
        discount = policy.base_discount
        
        # Fixed Feature Envy: Logic moved to Customer class
        discount += customer.get_membership_discount()
        
        if customer.is_loyal():
            discount += policy.loyalty_multiplier * 0.02
            
        return discount
