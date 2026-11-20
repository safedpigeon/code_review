from basic_printer import BasicPrinter
from multi_function_printer import MultiFunctionPrinter

def main():
    basic_printer = BasicPrinter()
    basic_printer.print_doc("Hello World")
    
    # The following would now cause an AttributeError, 
    # which is the desired behavior of ISP:
    # basic_printer.scan_doc("Hello World")

    mfp = MultiFunctionPrinter()
    mfp.print_doc("Test Doc")
    mfp.scan_doc("Test Doc")
    mfp.fax_doc("Test Doc")

if __name__ == "__main__":
    main()
