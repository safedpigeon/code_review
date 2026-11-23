from repository import ProductRepository

class ProductService:
    def __init__(self, repository: ProductRepository):
        self.repository = repository

    def get_all_products(self):
        # Service no longer depends on sqlite3.Cursor
        return self.repository.get_all_products()
