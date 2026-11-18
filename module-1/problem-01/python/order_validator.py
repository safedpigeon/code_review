import re

class OrderValidator:
    def validate(self, user_email, items):
        if not items or len(items) == 0:
            raise ValueError("Order must contain at least one item.")
        
        if not re.match(r"[^@]+@[^@]+\.[^@]+", user_email):
            raise ValueError("Invalid email address.")
