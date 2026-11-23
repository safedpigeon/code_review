import sqlite3
from security.naive_user_service import NaiveUserService

def setup_db():
    conn = sqlite3.connect(":memory:")
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE users (id TEXT, username TEXT, email TEXT)")
    cursor.execute("INSERT INTO users VALUES ('1', 'alice', 'alice@example.com')")
    cursor.execute("INSERT INTO users VALUES ('2', 'bob', 'bob@example.com')")
    conn.commit()
    return conn

def test_functional():
    conn = setup_db()
    service = NaiveUserService(conn)
    
    # Test basic functionality
    user = service.get_user_by_id('1')
    print(f"Expected: User(user_id='1', username='alice', email='alice@example.com'), Got: {user}")
    assert user is not None and user.username == 'alice'
    
    # Test that vulnerability is fixed (SQL Injection should no longer work)
    malicious_id = "' OR '1'='1"
    user_vuln = service.get_user_by_id(malicious_id)
    print(f"Malicious input: {malicious_id}, Got: {user_vuln}")
    assert user_vuln is None # Should NOT return a user now that it is fixed

if __name__ == "__main__":
    test_functional()
    print("Functional tests passed (including vulnerability demonstration)!")
