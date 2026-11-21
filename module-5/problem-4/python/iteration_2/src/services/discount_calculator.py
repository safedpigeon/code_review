class DiscountCalculator:
    def calculate_discount(self, amount, user_type):
        if not user_type:
            return 0.0
        user_type = user_type.upper()
        if user_type == "PREMIUM":
            return amount * 0.10
        if user_type == "GOLD":
            return amount * 0.20
        return 0.0
