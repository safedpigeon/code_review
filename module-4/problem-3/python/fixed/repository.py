import sqlite3
from product import Product

class ProductRepository:
    def __init__(self):
        self.connection = sqlite3.connect(":memory:")
        self._setup_db()

    def _setup_db(self):
        cursor = self.connection.cursor()
        cursor.execute("CREATE TABLE products (id INTEGER, name TEXT, price REAL)")
        cursor.execute("INSERT INTO products VALUES (1, 'Laptop', 1200.0)")
        cursor.execute("INSERT INTO products VALUES (2, 'Mouse', 25.0)")
        cursor.execute("INSERT INTO products VALUES (3, 'Keyboard', 75.0)")
        self.connection.commit()

    def get_all_products(self):
        print("[Repo] Fetching and mapping data to Domain objects...")
        cursor = self.connection.execute("SELECT * FROM products")
        
        # Mapping happens HERE, in the repository
        return [Product(row[0], row[1], row[2]) for row in cursor]
