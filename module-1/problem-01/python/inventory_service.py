class InventoryService:
    def update_inventory(self, items):
        for item in items:
            print(f"Updating inventory for item {item['id']}: reducing stock by {item['quantity']}.")
            # Simulate DB call: UPDATE inventory SET stock = stock - qty WHERE id = item_id
