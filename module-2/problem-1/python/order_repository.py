from models import Order

class OrderRepository:
    def save(self, order: Order):
        print(f"Saving order to database... Order ID: {order.order_id}")
