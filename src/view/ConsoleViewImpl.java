package view;

import util.ColorUtil;
import java.util.Scanner;

public class ConsoleViewImpl implements ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("\n" + ColorUtil.PURPLE + "╔══════════════════════════════════════════╗");
        System.out.println("║        PERSONAL BUDGET MANAGER           ║");
        System.out.println("╚══════════════════════════════════════════╝" + ColorUtil.RESET);
        System.out.println(ColorUtil.YELLOW + "[1]" + ColorUtil.RESET + " Add New Expense");
        System.out.println(ColorUtil.YELLOW + "[2]" + ColorUtil.RESET + " List All Expenses");
        System.out.println(ColorUtil.YELLOW + "[3]" + ColorUtil.RESET + " View Total Summary");
        System.out.println(ColorUtil.YELLOW + "[4]" + ColorUtil.RESET + " Category Breakdown");
        System.out.println(ColorUtil.YELLOW + "[5]" + ColorUtil.RESET + " Delete an Expense");
        System.out.println(ColorUtil.RED + "[0] Exit Application" + ColorUtil.RESET);
        ColorUtil.printSeparator();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(ColorUtil.GREEN + "✔ [SUCCESS]: " + ColorUtil.RESET + message);
    }

    @Override
    public void displayError(String message) {
        System.out.println(ColorUtil.RED + "✘ [ERROR]: " + message + ColorUtil.RESET);
    }

    @Override
    public String getInput(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(ColorUtil.CYAN + "➤ " + prompt + ": " + ColorUtil.RESET);
        } else {
            System.out.print(ColorUtil.WHITE_BOLD + "➤ Choice: " + ColorUtil.RESET);
        }
        return scanner.nextLine();
    }
}