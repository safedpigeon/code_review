package module_2.problem_4;

public class Main {
    public static void main(String[] args) {
        IPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World");
        
        // The following would now cause a compile-time error, 
        // which is the desired behavior of ISP:
        // basicPrinter.scan("Hello World");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Test Doc");
        mfp.scan("Test Doc");
        mfp.fax("Test Doc");
    }
}
