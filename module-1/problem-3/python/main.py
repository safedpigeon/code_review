from payment_service import PaymentService

def main():
    service = PaymentService()

    print("Test 1: Valid Payment")
    service.process_payment(100.0, "1234-5678-9012-3456")

    print("\nTest 2: Invalid Amount")
    service.process_payment(-10.0, "1234-5678-9012-3456")

    print("\nTest 3: Invalid Card")
    service.process_payment(100.0, "")

    print("\nTest 4: Amount too high")
    service.process_payment(20000.0, "1234-5678-9012-3456")

if __name__ == "__main__":
    main()
