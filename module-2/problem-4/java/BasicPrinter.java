package module_2.problem_4;

public class BasicPrinter implements IMachine {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException("BasicPrinter does not support scanning.");
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("BasicPrinter does not support faxing.");
    }
}
