package module_2.problem_4;

public class Main {
    public static void main(String[] args) {
        IMachine basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World");
        
        try {
            basicPrinter.scan("Hello World");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        IMachine mfp = new MultiFunctionPrinter();
        mfp.print("Test Doc");
        mfp.scan("Test Doc");
        mfp.fax("Test Doc");
    }
}
