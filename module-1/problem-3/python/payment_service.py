import logging
from payment_gateway import PaymentGateway

# Set up professional logging configuration
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger(__name__)

class PaymentError(Exception):
    """Base exception for payment service errors."""
    pass

class InvalidPaymentAmountError(PaymentError):
    """Raised when the payment amount is invalid."""
    pass

class PaymentService:
    def __init__(self, gateway=None):
        # Dependency Injection for better testability
        self.gateway = gateway or PaymentGateway()

    def process_payment(self, amount, card_number):
        try:
            if amount <= 0:
                raise InvalidPaymentAmountError(f"Payment amount must be positive. Provided: {amount}")
            
            success = self.gateway.charge(amount, card_number)
            if success:
                logger.info("Payment processed successfully!")
            else:
                raise PaymentError("Payment gateway declined the transaction.")
                
        except InvalidPaymentAmountError as e:
            logger.warning(f"Validation failed: {e}")
            raise
        except PaymentError as e:
            logger.error(f"Payment processing error: {e}")
            raise
        except Exception as e:
            # Catch unexpected errors and wrap them in a domain exception
            logger.exception("An unexpected system error occurred during payment processing")
            raise PaymentError(f"A system error occurred: {str(e)}") from e

