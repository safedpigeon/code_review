from machine import IMachine

class BasicPrinter(IMachine):
    def print_doc(self, document: str):
        print(f"Printing: {document}")

    def scan_doc(self, document: str):
        raise NotImplementedError("BasicPrinter does not support scanning.")

    def fax_doc(self, document: str):
        raise NotImplementedError("BasicPrinter does not support faxing.")
