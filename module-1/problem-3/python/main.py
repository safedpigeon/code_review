from bank_account import BankAccount

def main():
    account = BankAccount(100)

    try:
        account.deposit(50)
        print(f"Balance after deposit: {account.get_balance()}")

        account.withdraw(200)
    except Exception as e:
        print(f"Error: {e}")

    try:
        account.withdraw(-10)
    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main()
