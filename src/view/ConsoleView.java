package view;

import java.util.Scanner;

public class ConsoleViewImpl implements ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("\n--- PERSONAL BUDGET MANAGER ---");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Total Spending");
        System.out.println("4. View Spending by Category");
        System.out.println("5. Remove Expense");
        System.out.println("0. Exit");
        System.out.print("Selection: ");
    }

    @Override
    public void displayMessage(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void displayError(String message) {
        System.err.println("[ERROR] " + message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}