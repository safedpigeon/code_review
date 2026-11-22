class Customer:
    def __init__(self, name, membership_level, years_as_customer):
        self.name = name
        self.membership_level = membership_level  # "GOLD", "SILVER", "BRONZE"
        self.years_as_customer = years_as_customer

    def get_membership_discount(self):
        if self.membership_level == "GOLD": return 0.10
        if self.membership_level == "SILVER": return 0.05
        return 0.0

    def is_loyal(self):
        return self.years_as_customer > 5

