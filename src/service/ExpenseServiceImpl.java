package service;

import model.Category;
import model.Expense;
import repository.ExpenseRepository;
import util.ValidationUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addExpense(String description, double amount, Category category) {
        ValidationUtil.validateExpenseInput(description, amount);
        Expense expense = new Expense(description, amount, category);
        repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public double getTotalSpending() {
        return repository.findAll().stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    @Override
    public Map<Category, Double> getSpendingByCategory() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }

    @Override
    public boolean removeExpense(String id) {
        return repository.delete(id);
    }
}