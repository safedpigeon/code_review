from user import User

def main():
    user = User("Jane Doe", "jane@example.com")
    user.save()

    found_user = User.find_by_id(1)
    if found_user:
        print(f"Found User: {found_user.name}")

    user.delete()

if __name__ == "__main__":
    main()
