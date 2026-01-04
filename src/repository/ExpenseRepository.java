package repository;

import model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
    void save(Expense expense);

    boolean delete(String id);

    List<Expense> findAll();

    Optional<Expense> findById(String id);
}