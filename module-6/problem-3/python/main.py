from customer import Customer
from pricing_policy import PricingPolicy
from invoice import Invoice

if __name__ == "__main__":
    customer = Customer("John Doe", "GOLD", 6)
    policy = PricingPolicy(0.05, 1.5)
    invoice = Invoice()
    
    print(f"Discount: {invoice.calculate_discount(customer, policy)}")
