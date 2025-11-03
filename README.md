# Expense-Advisor



**Expense Advisor** is a Spring Boot web application that helps users manage their daily expenses with an easy-to-use interface.  
It supports user registration, login, expense tracking, editing, deleting, and searching — all stored securely in a MySQL database.

---

## 🚀 Features

✅ **User Authentication**
- Register and log in securely using session-based authentication.
- Logout functionality with session invalidation.

✅ **Expense Management**
- Add, edit, delete, and view expenses.
- Auto-set date of entry.
- Linked to the logged-in user using `userEmail`.

✅ **Search Functionality**
- Filter expenses dynamically by description.

✅ **JSP Frontend**
- Simple and responsive UI built using JSP + JSTL.

✅ **MySQL Database Integration**
- Uses Spring Data JPA for seamless ORM operations.

✅ **Spring Boot Powered**
- Modular MVC architecture for clarity and maintainability.

---

## 🧩 Project Structure

ExpenseAdvisor/
├── src/main/java/com/yash/ExpenseAdvisor/
│ ├── ExpenseAdvisorApplication.java # Main Spring Boot application
│ ├── controller/
│ │ ├── AuthController.java # Handles login, registration & logout
│ │ └── ExpenseController.java # Handles expense operations
│ ├── model/
│ │ ├── Expense.java # Entity for user expenses
│ │ └── User.java # Entity for users
│ ├── repository/
│ │ ├── ExpenseRepository.java
│ │ └── UserRepository.java
│ └── service/
│ ├── ExpenseService.java
│ └── UserService.java
│
├── src/main/resources/
│ ├── application.properties # Database & server config
│ └── static/ # CSS/JS (if any)
│
├── src/main/webapp/WEB-INF/jsp/ # JSP Views (login, register, viewExpenses, etc.)
│
├── pom.xml # Maven dependencies
└── README.md

yaml
Copy code

---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot 3.5.7, Spring MVC, Spring Data JPA |
| **Frontend** | JSP, JSTL |
| **Database** | MySQL 8+ |
| **Build Tool** | Maven |
| **Language** | Java 17 |
| **Server** | Embedded Tomcat (Spring Boot Starter Web) |

---

## 🛠️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/mathur407yash/Expense-Advisor.git
cd Expense-Advisor
2️⃣ Configure Database
Create a database in MySQL:

sql
Copy code
CREATE DATABASE expense_advisor;
Then open src/main/resources/application.properties and set your MySQL credentials:

properties
Copy code
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
3️⃣ Build and Run the Application
bash
Copy code
mvn spring-boot:run
OR run directly from your IDE (Eclipse/IntelliJ):

mathematica
Copy code
Run → ExpenseAdvisorApplication.java
4️⃣ Access in Browser
arduino
Copy code
http://localhost:8080
🧑‍💻 Core Functionalities
🔐 Authentication
Register → /register

Login → /login

Logout → /logout

💵 Expense Management
View all expenses → /expenses/view

Add a new expense → /expenses/addExpense

Edit expense → /expenses/edit/{id}

Delete expense → /expenses/delete/{id}

Search expenses → /expenses/search?keyword=<text>

🧱 Database Tables
users
Column	Type	Description
id	BIGINT (PK)	Auto-generated
name	VARCHAR	User’s full name
email	VARCHAR (Unique)	Login email
password	VARCHAR	Plain text password (hashing can be added later)

expense
Column	Type	Description
id	BIGINT (PK)	Auto-generated
description	VARCHAR	Expense details
amount	DOUBLE	Expense amount
date	DATE	Auto-set to current date
user_email	VARCHAR	Foreign key link to user

🧩 Future Enhancements
🔒 Integrate Spring Security with BCrypt password hashing

📊 Add charts (monthly spending summary)

📁 Add category-wise expense classification

☁️ Deploy to AWS / Render


