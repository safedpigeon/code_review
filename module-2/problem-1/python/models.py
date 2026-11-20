from dataclasses import dataclass
from typing import List, Dict, Any

@dataclass
class Item:
    name: str
    price: float
    quantity: int

@dataclass
class Order:
    order_id: str
    customer_email: str
    items: List[Item]
