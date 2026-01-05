package controller;

import exception.BudgetException;
import model.Category;
import model.Expense;
import service.ExpenseService;
import view.ConsoleView;

import java.util.List;

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

    private void handleAddExpense() {
        try {
            String desc = view.getInput("Description");
            String amountStr = view.getInput("Amount");
            double amount = Double.parseDouble(amountStr);

            String catStr = view.getInput("Category (FOOD, TRANSPORTATION, UTILITIES, ENTERTAINMENT, CLOTHING, HEALTH, OTHER)");
            Category category = Category.fromString(catStr);

            service.addExpense(desc, amount, category);
            view.displayMessage("Expense added successfully!");
        } catch (NumberFormatException e) {
            view.displayError("Invalid amount format! Please enter a number.");
        } catch (BudgetException e) {
            view.displayError(e.getMessage());
        }
    }

    private void handleViewAll() {
        var expenses = service.getAllExpenses();
        if (expenses.isEmpty()) {
            view.displayError("No expenses found!");
            return;
        }

        System.out.println("\n" + util.ColorUtil.WHITE_BOLD + String.format("%-15s | %-10s | %-20s", "CATEGORY", "AMOUNT", "DESCRIPTION") + util.ColorUtil.RESET);
        util.ColorUtil.printSeparator();

        expenses.forEach(e -> {
            System.out.printf("%-15s | %-10.2f | %-20s%n",
                    e.getCategory(),
                    e.getAmount(),
                    e.getDescription());
        });
        util.ColorUtil.printSeparator();
    }

    private void handleTotalSpending() {
        double total = service.getTotalSpending();
        view.displayMessage("Total Spending: " + total);
    }

    private void handleCategorySpending() {
        view.displayMessage("--- Spending by Category ---");
        service.getSpendingByCategory().forEach((cat, amt) ->
                System.out.println(cat + ": " + amt));
    }

    private void handleRemoveExpense() {
        String id = view.getInput("Enter Expense ID to remove");
        boolean removed = service.removeExpense(id);
        if (removed) {
            view.displayMessage("Expense removed successfully!");
        } else {
            view.displayError("Expense not found with given ID!");
        }
    }
}