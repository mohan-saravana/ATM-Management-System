# Timetable-Management-System
# ATM Management System

##  Project Title

**ATM Management System**

A desktop-based banking application developed using **Java Swing, JDBC, and MySQL** with a layered architecture. The system provides basic ATM operations through a simple graphical user interface.

---

##  Synopsis

The **ATM Management System** is a Java desktop application designed to simulate common ATM and banking operations.

The application provides a graphical user interface using **Java Swing** and uses **JDBC** to connect with a **MySQL database** for storing and retrieving account and transaction information.

Users can securely log in using their account number and PIN and perform operations such as checking balance, depositing money, withdrawing money, transferring money, viewing transaction history, and changing their ATM PIN.

The project follows a **layered architecture**, separating the GUI, business logic, database operations, JDBC connectivity, and database layers.

---

##  Problem Statement

Traditional banking operations require users to visit a bank or ATM for simple account activities. Managing account information and transactions manually can also lead to difficulties in maintaining accurate records.

The main problems addressed by this project are:

* Difficulty in managing basic banking operations efficiently.
* Need for secure user authentication.
* Manual management of account balances and transactions.
* Lack of centralized transaction records.
* Difficulty in maintaining and extending banking software.

The proposed ATM Management System provides a computerized solution for performing basic banking operations through a simple graphical interface.

---

##  Technologies Used

| Technology      | Purpose                           |
| --------------- | --------------------------------- |
| **Java**        | Core programming language         |
| **Java Swing**  | Graphical User Interface          |
| **JDBC**        | Database connectivity             |
| **MySQL**       | Relational database               |
| **Maven**       | Project and dependency management |
| **Eclipse IDE** | Development environment           |

These technologies are specified in the project presentation.

---

##  Features of the Project

###  1. User Login

* Login using account number and PIN.
* Validates credentials against the database.
* Opens the dashboard after successful authentication.
* Displays an error message for invalid credentials.

###  2. Balance Inquiry

* Retrieves the current account balance from MySQL.
* Displays the balance to the user.

###  3. Deposit

* Allows users to deposit money.
* Updates the account balance.
* Records the transaction.

###  4. Withdrawal

* Allows users to withdraw money.
* Checks whether sufficient balance is available.
* Deducts the amount from the account.
* Records the transaction.

###  5. Money Transfer

* Transfers money from one account to another.
* Deducts money from the source account.
* Deposits money into the destination account.

###  6. Mini Statement

* Displays the user's transaction history.
* Shows transaction type, amount, and transaction date.

###  7. PIN Change

* Validates the existing PIN.
* Allows the user to update the ATM PIN.

The project presentation identifies these as the major ATM operations.

---

##  Project Architecture

The project follows a **Layered Architecture**:

```text
┌──────────────────────────────┐
│        GUI Layer             │
│      Java Swing Screens      │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│       Service Layer          │
│ Business Logic & Validation  │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│          DAO Layer            │
│    Database Operations        │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│       JDBC Utility            │
│    Database Connection        │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│       Database Layer          │
│           MySQL              │
└──────────────────────────────┘
```

### Architecture Layers

**GUI Layer**

* Provides Swing-based screens.
* Handles user interaction.

**Service Layer**

* Contains business logic.
* Performs validation before database operations.

**DAO Layer**

* Performs database operations.
* Uses SQL queries to insert, update, and retrieve information.

**JDBC Utility**

* Establishes the connection between Java and MySQL.
* Uses `DriverManager` and `PreparedStatement`.
* Uses try-with-resources for safe resource management.

**Database Layer**

* Stores user account and transaction information in MySQL.

---

##  Database Structure

### Database Name

```text
atm_db
```

### Users Table

```text
users
-------------------------
account_no
name
pin
balance
```

### Transactions Table

```text
transactions
-------------------------
transaction_id
account_no
transaction_type
amount
transaction_date
```

A foreign key connects the `transactions` table with the `users` table.

---

##  Project Modules

* Login Module
* Dashboard Module
* Balance Inquiry Module
* Deposit Module
* Withdrawal Module
* Money Transfer Module
* Mini Statement Module
* PIN Change Module

---

##  Security and Database Handling

The application uses **parameterized SQL queries with `PreparedStatement`**, helping make database operations safer. JDBC resources are managed using **try-with-resources**.

---

##  Advantages

* Easy-to-use graphical interface.
* Centralized database storage.
* Layered architecture improves maintainability.
* Prepared statements improve SQL safety.
* Transaction history can be viewed.
* Easy to extend with additional banking features.

---

##  Testing

The project covers testing of:

* Database connectivity
* Valid login
* Invalid login
* Balance inquiry
* Deposit
* Withdrawal
* Insufficient balance handling
* Money transfer
* Mini statement
* PIN change

---

##  Future Enhancements

The system can be further enhanced by adding:

* Admin management
* Account creation
* Receipt printing
* Improved security
* Additional banking services

These enhancements are also identified in the project presentation.

---

##  Conclusion

The **ATM Management System** demonstrates a complete Java desktop application using **Java Swing, JDBC, and MySQL**.

The layered architecture separates presentation, business logic, and database operations, making the application easier to maintain and extend. The system successfully provides essential ATM functions such as login, balance inquiry, deposit, withdrawal, money transfer, mini statement, and PIN change.

Overall, the project provides a practical example of developing a database-driven Java desktop application using a structured layered architecture.

---



---
