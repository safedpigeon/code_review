from m4p4.order_service import OrderService
from m4p4.database import db

def main():
    order_service = OrderService()

    print("--- Scenario 1: Successful Order ---")
    try:
        order_service.place_order("PROD1", 2)
    except Exception as e:
        print(f"Unexpected error: {e}")

    print("\n--- Scenario 2: Failed Order (Insufficient Stock) ---")
    try:
        order_service.place_order("PROD1", 20)
    except Exception as e:
        print(f"Caught expected exception: {e}")

    print("\n--- Scenario 3: Failed Order (System Crash) ---")
    try:
        order_service.place_order("FAIL", 1)
    except Exception as e:
        print(f"Caught expected exception: {e}")

    print("\n--- Final Database State ---")
    print(f"Orders in DB: {db.orders}")
    print(f"Inventory in DB: {db.inventory}")
    
    print("\nObservation: The system now maintains atomicity. Failed orders are rolled back and do not persist in the database.")

if __name__ == "__main__":
    main()
