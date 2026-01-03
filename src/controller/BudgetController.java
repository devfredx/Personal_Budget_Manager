package controller;

import service.ExpenseService;
import view.ConsoleView;
import model.Category;
import exception.BudgetException;

public class BudgetController {
    private final ExpenseService service;
    private final ConsoleView view;

    public BudgetController(ExpenseService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            String choice = view.getInput("");

            switch (choice) {
                case "1" -> handleAddExpense();
                case "2" -> handleViewAll();
                case "3" -> handleTotalSpending();
                case "4" -> handleCategorySpending();
                case "5" -> handleRemoveExpense();
                case "0" -> {
                    running = false;
                    view.displayMessage("Exiting... Goodbye!");
                }
                default -> view.displayError("Invalid selection!");
            }
        }
    }

    // Empty methods to be filled in next steps
    private void handleAddExpense() {}
    private void handleViewAll() {}
    private void handleTotalSpending() {}
    private void handleCategorySpending() {}
    private void handleRemoveExpense() {}

}
private void handleAddExpense() {
    try {
        String desc = view.getInput("Description");
        double amount = Double.parseDouble(view.getInput("Amount"));
        String catStr = view.getInput("Category (FOOD, TRANSPORTATION, etc.)");
        Category category = Category.fromString(catStr);

        service.addExpense(desc, amount, category);
        view.displayMessage("Expense added successfully!");
    } catch (NumberFormatException e) {
        view.displayError("Invalid amount format!");
    } catch (BudgetException e) {
        view.displayError(e.getMessage());
    }
}