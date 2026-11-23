from user import User
from user_repository import UserRepository

def main():
    user_repository = UserRepository()
    
    user = User("Jane Doe", "jane@example.com")
    user_repository.save(user)

    found_user = user_repository.find_by_id(1)
    if found_user:
        print(f"Found User: {found_user.name}")

    user_repository.delete(user)

if __name__ == "__main__":
    main()

