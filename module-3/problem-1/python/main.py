from database_manager import DatabaseManager
from user_service import UserService

if __name__ == "__main__":
    # Manual Dependency Injection
    db = DatabaseManager()
    user_service = UserService(db)
    
    user_service.create_user("JohnDoe")
    user_service.create_user("JaneDoe")
