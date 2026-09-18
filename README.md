# 🎮 Game Store System

A console-based **Game Store Management System** built in **Java** using Object-Oriented Programming (OOP) principles. This project simulates a simple game store where users can browse games, add them to a cart, and admins can manage the game inventory.

## 📌 Features

- **User & Admin Roles** – Separate functionalities for regular users and admins
- **Authentication System** – Secure login/signup handling via `AuthManager`
- **Game Management** – Add, update, remove, and search games (Admin)
- **Shopping Cart** – Users can add/remove games from their cart before checkout
- **Save & Load Game Data** – Persist game list data using file handling
- **Custom Exception Handling** – Gracefully handles invalid game searches with `GameNotFoundException`
- **Clean Console Output** – Formatted and user-friendly display using `DisplayUtils`

## 🛠️ Tech Stack

- **Language:** Java
- **Paradigm:** Object-Oriented Programming (OOP)
- **Concepts Used:** Inheritance, Polymorphism, Encapsulation, Abstraction, Exception Handling, File Handling

## 📂 Project Structure


## 🧩 OOP Concepts Implemented

| Concept | Where it's used |
|---------|-----------------|
| **Inheritance** | `User` and `Admin` extend `Person` |
| **Encapsulation** | Private fields with getters/setters in model classes |
| **Abstraction** | `Person` acts as a base/abstract layer for roles |
| **Polymorphism** | Overridden methods for User/Admin specific behavior |
| **Exception Handling** | Custom `GameNotFoundException` for error handling |
| **File Handling** | `SaveGameList` for persisting data |

## 🚀 How to Run

1. Clone the repository
```bash
   git clone https://github.com/Nobab128Game-Store-System-(OOP)-.git
```
2. Navigate to the project folder
```bash
   cd Game-Store-System-(OOP)-
```
3. Compile all Java files
```bash
   javac *.java
```
4. Run the main class
```bash
   java Game-Store-System-(OOP)-
```

## 📖 About

This project was developed as part of my **Object-Oriented Programming** coursework in my last semester, to practice and demonstrate core OOP concepts through a real-world inspired application.

## 👤 Author

- **Your Name**
- GitHub:https://github.com/Nobab128

## 📝 License

This project is open source and available for educational purposes.
