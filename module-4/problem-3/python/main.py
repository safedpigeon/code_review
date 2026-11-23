from repository import ProductRepository
from service import ProductService

def main():
    repository = ProductRepository()
    service = ProductService(repository)
    
    products = service.get_all_products()
    
    print("\n--- Product List ---")
    for p in products:
        print(p)

if __name__ == "__main__":
    main()
