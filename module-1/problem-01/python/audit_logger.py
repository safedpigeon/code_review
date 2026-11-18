import datetime

class AuditLogger:
    def log_order(self, order_id, user_email):
        with open("order_logs.txt", "a") as log_file:
            log_file.write(f"[{datetime.datetime.now()}] Order {order_id} processed for {user_email}\n")
