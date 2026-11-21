from typing import List

class SecurityFilter:
    """
    SecurityFilter handles the filtering of blocked IP addresses.
    In this naive implementation, we use a list to store blocked IPs.
    """
    def __init__(self):
        self.blocked_ips: List[str] = []

    def add_blocked_ip(self, ip: str):
        self.blocked_ips.append(ip)

    def is_blocked(self, ip: str) -> bool:
        # Linear search through the list to check if IP is blocked
        for blocked_ip in self.blocked_ips:
            if blocked_ip == ip:
                return True
        return False

if __name__ == "__main__":
    import time
    
    filter_obj = SecurityFilter()
    # Simulating a large blocklist
    for i in range(10000):
        filter_obj.add_blocked_ip(f"192.168.1.{i}")

    start_time = time.time_ns()
    blocked = filter_obj.is_blocked("192.168.1.9999")
    end_time = time.time_ns()

    print(f"Is blocked: {blocked}")
    print(f"Time taken: {end_time - start_time} ns")
