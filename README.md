# FIAP Project: Java Product Manager

A console-based application (utilizing Java Swing for dialogs) for managing products and categories. This system was developed as a final project for the Java course at FIAP.

The application allows users to perform basic CRUD (Create, Read, Update) operations for products, associating them with categories. All data is persisted in-memory during execution.

## 🚀 Key Features

  * ✅ **Category Registration**: Add new product categories.
  * 📦 **Product Registration**: Add new products and link them to an existing category.
  * ✏️ **Product Update**: Modify data of an already registered product.
  * 🔎 **Find Product by ID**: Search for a specific product using its unique identifier.
  * 🗂️ **List Products by Category**: Display all products belonging to a selected category.
  * 🚪 **Exit**: Safely close the application.

## 💻 Technologies Used

  * **Java**: The project is built with Java (configured in `pom.xml` to compile using version 14).
  * **Maven**: Used for dependency management and project building.
  * **Java Swing (`JOptionPane`)**: The user interface is entirely based on Swing dialog boxes, providing a straightforward interaction flow without the need for a complex GUI.

## 📁 Project Structure

The project follows a clean architecture layout, separating responsibilities into different packages:

  * `br.com.fiap.produtos`
      * `Main.java`: Application entry point; contains the main menu loop.
  * `br.com.fiap.produtos.model`
      * `Product.java`: Entity (POJO) representing a product.
      * `Category.java`: Entity (POJO) representing a category.
  * `br.com.fiap.produtos.repository`
      * `ProductCollectionRepository.java`: Simulates the persistence layer for Products, storing data in a static `Vector`.
      * `CategoryCollectionRepository.java`: Simulates the persistence layer for Categories, storing initial seeded data in a static `Vector`.
  * `br.com.fiap.produtos.view`
      * `Opcao.java` / `OpcaoView.java`: Controls the display and selection of main menu options.
      * `ProductView.java`: Responsible for displaying form dialogs (`JOptionPane`) for product data entry.
      * `CategoryView.java`: Responsible for displaying form dialogs (`JOptionPane`) for category data entry.

## ▶️ How to Run the Project

### Prerequisites

  * Java JDK (version 14 or higher).
  * Apache Maven.

### Execution

1. **Open the project in your favorite IDE** (IntelliJ, Eclipse, VS Code with Java extension) that supports Maven projects.
2. **Synchronize Maven dependencies.**
3. **Locate and run the `main` method** inside the `br.com.fiap.produtos.Main.java` class.

**Alternatively, via Command Line Interface (CLI):**

1. Navigate to the project's root folder (where the `pom.xml` is located).
2. Compile the project:
   ```bash
   mvn clean compile
   ```
3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="br.com.fiap.produtos.Main"
   ```
