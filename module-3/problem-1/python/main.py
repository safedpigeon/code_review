from user_service import UserService

if __name__ == "__main__":
    user_service = UserService()
    user_service.create_user("JohnDoe")
    user_service.create_user("JaneDoe")
