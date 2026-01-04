import controller.BudgetController;
import repository.ExpenseRepository;
import repository.InMemoryExpenseRepository;
import service.ExpenseService;
import service.ExpenseServiceImpl;
import view.ConsoleView;
import view.ConsoleViewImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Personal Budget Manager...");

        // 1. Initialize Repository (Data Layer)
        ExpenseRepository repository = new InMemoryExpenseRepository();

        // 2. Initialize Service (Business Layer)
        ExpenseService service = new ExpenseServiceImpl(repository);

        // 3. Initialize View (Presentation Layer)
        ConsoleView view = new ConsoleViewImpl();

        // 4. Initialize Controller (Application Flow)
        BudgetController controller = new BudgetController(service, view);

        // 5. Run the Application
        controller.run();
    }
}