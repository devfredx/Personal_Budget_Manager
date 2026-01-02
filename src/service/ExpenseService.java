package service;

import model.Category;
import model.Expense;
import java.util.List;
import java.util.Map;

public interface ExpenseService {
    void addExpense(String description, double amount, Category category);
    List<Expense> getAllExpenses();
    double getTotalSpending();
    Map<Category, Double> getSpendingByCategory();
    boolean removeExpense(String id);
}