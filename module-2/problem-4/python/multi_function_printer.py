from machine import IMachine

class MultiFunctionPrinter(IMachine):
    def print_doc(self, document: str):
        print(f"Printing: {document}")

    def scan_doc(self, document: str):
        print(f"Scanning: {document}")

    def fax_doc(self, document: str):
        print(f"Faxing: {document}")
