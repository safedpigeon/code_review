package module_2.problem_4;

public class BasicPrinter implements IPrinter {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}
