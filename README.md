# Personal Budget Manager

A console-based Java application to manage personal expenses using **Layered Architecture** and **OOP principles**.

## 🚀 Features

- **Add Expense:** Record new expenses with description, amount, and category.
- **View All:** List all recorded expenses with details.
- **Total Calculation:** Calculate total spending instantly.
- **Category Analysis:** View spending breakdown by category (Food, Transport, etc.).
- **Remove Expense:** Delete expenses by ID.
- **In-Memory Storage:** Data is preserved during the runtime session.

## 🛠 Technologies Used

- **Language:** Java 17+
- **Architecture:** Layered Architecture (Controller -> Service -> Repository)
- **Concepts:** Interfaces, Enums, Stream API, Exception Handling, Singleton Pattern (Logic).

## 📂 Project Structure

```bash
src/
├── controller/   # Handles application flow and user input
├── model/        # Entity and Enum definitions
├── repository/   # Data access layer (In-Memory implementation)
├── service/      # Business logic and validation
├── view/         # Console UI implementation
├── util/         # Helper classes (Validation)
└── Main.java     # Application entry point with Dependency Injection   
```
## ⚡ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run the `Main.java` file.
4. Follow the on-screen menu instructions.

