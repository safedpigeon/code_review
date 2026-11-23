from product import Product
from repository import ProductRepository

class ProductService:
    def __init__(self, repository: ProductRepository):
        self.repository = repository

    def get_all_products(self):
        print("[Service] Converting raw SQLite cursor to Domain objects...")
        products = []
        
        # LEAK: Service depends on the sqlite3.Cursor returned by the repository
        cursor = self.repository.get_all_products_cursor()
        
        for row in cursor:
            # Service has to know that row[0] is id, row[1] is name, etc.
            products.append(Product(row[0], row[1], row[2]))
            
        return products
