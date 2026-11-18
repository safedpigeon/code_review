class BankTransferNaive:
    def transfer(self, from_acc, to_acc, amount):
        try:
            print(f"Transferring {amount} from {from_acc} to {to_acc}...")
            
            if from_acc == "Acc1" and amount > 500:
                raise Exception("Insufficient funds!")
            
            if to_acc == "Unknown":
                raise Exception("Account not found!")
            
            print("Transfer successful!")
        except Exception as e:
            print(f"Error occurred: {e}")

if __name__ == "__main__":
    bank = BankTransferNaive()
    
    # Case 1: Success
    bank.transfer("Acc1", "Acc2", 100)
    
    # Case 2: Insufficient funds
    bank.transfer("Acc1", "Acc2", 10000)
    
    # Case 3: Non-existent account
    bank.transfer("Acc1", "Unknown", 50)
