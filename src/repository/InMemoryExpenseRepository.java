package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private final List<Expense> expenses = new ArrayList<>();

    @Override
    public void save(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public boolean delete(String id) {
        return expenses.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(expenses);
    }

    @Override
    public Optional<Expense> findById(String id) {
        return expenses.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }
}