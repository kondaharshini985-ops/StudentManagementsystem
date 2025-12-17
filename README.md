# 📘 Student Management Web Application

## 📌 Project Description
The **Student Management Web Application** is a Java-based web application developed using **JSP, Servlets, JDBC, and MySQL**.  
It allows students to **register (signup)**, **login**, and **reset their password (forget password)** securely.

The project follows a **layered MVC architecture** using **DTO (Data Transfer Object)** and **DAO (Data Access Object)** patterns to separate presentation, business logic, and database operations.

---

## 🛠 Technologies Used
- Frontend: JSP, HTML, CSS  
- Backend: Java Servlets  
- Database: MySQL  
- Connectivity: JDBC  
- Server: Apache Tomcat 10  
- IDE: Eclipse / STS  
- JDK: Java 17+

---

## 📂 Project Structure
StudentDynamicProject
│
├── src/main/java
│ ├── com.project.Student
│ │ ├── SignUp.java
│ │ └── Login.java
│ │
│ ├── com.pentagon.studentDTO
│ │ └── Student.java
│ │
│ ├── com.pentagon.student.DAO
│ │ ├── StudentDAO.java
│ │ └── StudentDAOImlp.java
│ │
│ └── com.pentagon.student.db
│ └── Connector.java
│
├── src/main/webapp
│ ├── signup.jsp
│ ├── login.jsp
│ ├── forgetpassword.jsp
│
└── README.md

---

## ⚙️ Features
- ✔ Student Registration (Signup)
- ✔ Login Authentication
- ✔ Forget Password / Reset Password
- ✔ Form Validation
- ✔ Secure Database Access using PreparedStatement
- ✔ MVC Architecture using JSP and Servlets

---

## 🧩 Database Design

### Database Name
student

pgsql
Copy code

### Table Structure
```sql
CREATE TABLE student(
   sid INT AUTO_INCREMENT PRIMARY KEY,
   phone BIGINT,
   name VARCHAR(50),
   email VARCHAR(60),
   branch VARCHAR(20),
   location VARCHAR(20),
   password VARCHAR(30),
   date DATETIME
);
🔄 Application Flow
1️⃣ Signup Flow

signup.jsp → SignUp Servlet → Student DTO → StudentDAO → MySQL
                                   ↓
                             login.jsp (success)
2️⃣ Login Flow

login.jsp → Login Servlet → StudentDAO → MySQL
                           ↓
                      login.jsp (success / fail)
3️⃣ Forget Password Flow

forgetpassword.jsp → Forget Servlet → StudentDAO → MySQL
                                         ↓
                                   Message Display
🧠 Design Patterns Used
DTO (Data Transfer Object)
Student.java

Used to transfer student data between Servlet and DAO layers

DAO (Data Access Object)
StudentDAO, StudentDAOImlp

Contains all database-related logic

🔐 Security Measures

PreparedStatement used to prevent SQL Injection
Password confirmation during signup
Server-side validation in Servlets

▶️ How to Run the Project
Install Java JDK 17+
Install Apache Tomcat 10
Create the MySQL database and table
Update DB credentials in Connector.java
Import the project into Eclipse / STS
Run the project on Tomcat server

Access the application in browser:
http://localhost:8080/StudentDynamicProject/signup.jsp

📌 Future Enhancements
Session management after login

Password encryption (BCrypt)
Role-based access control
Dashboard page after login
Migration to Spring Boot


👩‍💻 Author
Harshini Konda
Java Web Developer
Skills: Java, JSP, Servlets, JDBC, MySQL

✅ Conclusion
This project demonstrates a complete Java web application with clean architecture, proper validation, and database integration.
