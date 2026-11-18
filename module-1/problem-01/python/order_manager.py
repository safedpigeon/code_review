from order_validator import OrderValidator
from payment_service import PaymentService
from inventory_service import InventoryService
from shipping_service import ShippingService
from notification_service import NotificationService
from audit_logger import AuditLogger

class OrderManager:
    """
    The Orchestrator - coordinates between specialized services to process an order.
    """

    def __init__(self, validator, payment_service, inventory_service, shipping_service, notification_service, audit_logger):
        self.validator = validator
        self.payment_service = payment_service
        self.inventory_service = inventory_service
        self.shipping_service = shipping_service
        self.notification_service = notification_service
        self.audit_logger = audit_logger

    def process_order(self, order_id, user_email, items, credit_card_details):
        print(f"Processing order {order_id}...")

        # 1. Validation
        self.validator.validate(user_email, items)

        # 2. Payment Processing
        self.payment_service.process_payment(credit_card_details)

        # 3. Inventory Management
        self.inventory_service.update_inventory(items)

        # 4. Shipping Calculation
        self.shipping_service.calculate_shipping(items)

        # 5. Notification
        self.notification_service.send_confirmation_email(user_email, order_id)

        # 6. Audit Logging
        self.audit_logger.log_order(order_id, user_email)

        print("Order processing completed successfully.")

if __name__ == "__main__":
    # Dependency Injection
    manager = OrderManager(
        OrderValidator(),
        PaymentService(),
        InventoryService(),
        ShippingService(),
        NotificationService(),
        AuditLogger()
    )
    try:
        manager.process_order(
            order_id="ORD-123",
            user_email="student@example.com",
            items=[{"id": 1, "quantity": 2, "weight": 1.5}],
            credit_card_details={"number": "1234-5678-9012-3456"}
        )
    except Exception as e:
        print(f"Error: {e}")
