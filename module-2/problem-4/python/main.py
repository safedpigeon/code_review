from basic_printer import BasicPrinter
from multi_function_printer import MultiFunctionPrinter

def main():
    basic_printer = BasicPrinter()
    basic_printer.print_doc("Hello World")
    
    try:
        basic_printer.scan_doc("Hello World")
    except NotImplementedError as e:
        print(f"Caught expected error: {e}")

    mfp = MultiFunctionPrinter()
    mfp.print_doc("Test Doc")
    mfp.scan_doc("Test Doc")
    mfp.fax_doc("Test Doc")

if __name__ == "__main__":
    main()
