from models import Order, Item
from order_validator import OrderValidator
from price_calculator import PriceCalculator
from order_repository import OrderRepository
from notification_service import NotificationService

class OrderProcessor:
    def __init__(self, validator: OrderValidator, calculator: PriceCalculator, 
                 repository: OrderRepository, notification_service: NotificationService):
        self.validator = validator
        self.calculator = calculator
        self.repository = repository
        self.notification_service = notification_service

    def process_order(self, order: Order):
        self.validator.validate(order)
        self.calculator.calculate_final_amount(order)
        self.repository.save(order)
        self.notification_service.send_confirmation(order)

if __name__ == "__main__":
    items = [
        Item(name='Laptop', price=1200.0, quantity=1),
        Item(name='Mouse', price=25.0, quantity=2)
    ]
    order = Order(order_id="ORD-123", customer_email="customer@example.com", items=items)
    
    processor = OrderProcessor(
        OrderValidator(),
        PriceCalculator(),
        OrderRepository(),
        NotificationService()
    )
    processor.process_order(order)

