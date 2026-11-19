from user_service import UserService

def main():
    user_service = UserService()

    print("Fetching existing user:")
    user1 = user_service.get_user("1")
    print(f"Found: {user1.name if user1 else 'None'}")

    print("\nFetching non-existent user:")
    user2 = user_service.get_user("3")
    print(f"Found: {user2.name if user2 else 'None'}")

    print("\nFetching with None ID:")
    user3 = user_service.get_user(None)
    print(f"Found: {user3.name if user3 else 'None'}")

    print("\nUpdating non-existent user:")
    user_service.update_user_name("3", "Charlie")

if __name__ == "__main__":
    main()
