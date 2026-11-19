from config import AppConfig
from payment_service import PaymentService

def main():
    config = AppConfig()
    service = PaymentService(config)
    service.process_payment(250.0)

if __name__ == "__main__":
    main()
