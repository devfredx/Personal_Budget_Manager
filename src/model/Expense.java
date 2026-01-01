package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Expense {
    private final String id;
    private String description;
    private double amount;
    private Category category;
    private LocalDateTime date;

    public Expense(String description, double amount, Category category) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public LocalDateTime getDate() { return date; }

    // Setters
    public void setDescription(String description) { this.description = description; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                '}';
    }
}