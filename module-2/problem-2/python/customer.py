from enum import Enum

class CustomerType(Enum):
    REGULAR = 1
    VIP = 2
    PREMIUM = 3

class Customer:
    def __init__(self, customer_type: CustomerType, amount: float):
        self.customer_type = customer_type
        self.amount = amount
