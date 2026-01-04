package view;

public interface ConsoleView {
    void showMenu();
    void displayMessage(String message);
    void displayError(String message);
    String getInput(String prompt);
}