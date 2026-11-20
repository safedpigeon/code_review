from machine import IPrinter

class BasicPrinter(IPrinter):
    def print_doc(self, document: str):
        print(f"Printing: {document}")
