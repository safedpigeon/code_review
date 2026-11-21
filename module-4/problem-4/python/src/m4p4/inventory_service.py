from .database import db

class InventoryService:
    def deduct_stock(self, product_id, quantity):
        current_stock = db.inventory.get(product_id, 0)
        print(f"[InventoryService] Deducting stock for {product_id}: {current_stock} -> {current_stock - quantity}")

        if quantity > current_stock:
            raise Exception(f"Insufficient stock for product: {product_id}")

        if product_id == "FAIL":
            raise Exception("Database connection failed in InventoryService!")

        db.inventory[product_id] = current_stock - quantity
