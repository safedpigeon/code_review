from typing import Set

class SecurityFilter:
    """
    SecurityFilter handles the filtering of blocked IP addresses.
    In this optimized implementation, we use a set to store blocked IPs,
    providing O(1) average time complexity for lookups.
    """
    def __init__(self):
        self.blocked_ips: Set[str] = set()

    def add_blocked_ip(self, ip: str):
        self.blocked_ips.add(ip)

    def is_blocked(self, ip: str) -> bool:
        # set in Python is implemented as a hash table, providing O(1) average complexity
        return ip in self.blocked_ips

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
