from customer import Customer, CustomerType

class DiscountCalculator:
    def calculate_discount(self, customer: Customer) -> float:
        if customer.customer_type == CustomerType.REGULAR:
            return customer.amount * 0.05
        elif customer.customer_type == CustomerType.VIP:
            return customer.amount * 0.10
        elif customer.customer_type == CustomerType.PREMIUM:
            return customer.amount * 0.20
        else:
            return 0.0

if __name__ == "__main__":
    customer = Customer(CustomerType.VIP, 100.0)
    calculator = DiscountCalculator()
    print(f"Discount: {calculator.calculate_discount(customer)}")
