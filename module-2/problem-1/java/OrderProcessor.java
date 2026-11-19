package module2.problem1;
import java.util.*;

public class OrderProcessor {
    private final OrderValidator validator;
    private final PriceCalculator calculator;
    private final OrderRepository repository;
    private final NotificationService notificationService;

    public OrderProcessor(OrderValidator validator, PriceCalculator calculator, 
                          OrderRepository repository, NotificationService notificationService) {
        this.validator = validator;
        this.calculator = calculator;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) {
        validator.validate(order);
        calculator.calculateFinalAmount(order);
        repository.save(order);
        notificationService.sendConfirmation(order);
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("Laptop", 1200.0, 1), new Item("Mouse", 25.0, 2));
        Order order = new Order("ORD-123", "customer@example.com", items);
        
        OrderProcessor processor = new OrderProcessor(
            new OrderValidator(),
            new PriceCalculator(),
            new OrderRepository(),
            new NotificationService()
        );
        processor.processOrder(order);
    }
}

