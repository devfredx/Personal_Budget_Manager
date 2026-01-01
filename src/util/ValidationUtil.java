package util;

public class ValidationUtil {

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static void validateExpenseInput(String description, double amount) {
        if (!isValidString(description)) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }
}