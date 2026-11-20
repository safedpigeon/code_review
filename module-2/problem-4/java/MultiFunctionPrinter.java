package module_2.problem_4;

public class MultiFunctionPrinter implements IPrinter, IScanner, IFax {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("Faxing: " + document);
    }
}
