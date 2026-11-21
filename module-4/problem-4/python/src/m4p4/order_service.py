import uuid
from .database import db
from .models import Order
from .inventory_service import InventoryService

class OrderService:
    def __init__(self):
        self.inventory_service = InventoryService()

    def place_order(self, product_id, quantity):
        order_id = str(uuid.uuid4())
        order = Order(order_id, product_id, quantity)
        
        # Corrected implementation: Using a compensating transaction (Saga pattern)
        print(f"[OrderService] Creating order: {order}")
        db.orders.append(order_id)
        
        try:
            self.inventory_service.deduct_stock(product_id, quantity)
            print("[OrderService] Order placed successfully!")
        except Exception as e:
            print(f"[OrderService] Error while placing order: {str(e)}")
            
            # COMPENSATING TRANSACTION: Undo the order creation to maintain consistency.
            print(f"[OrderService] Rolling back order {order_id} due to failure...")
            db.orders.remove(order_id)
            
            raise e
