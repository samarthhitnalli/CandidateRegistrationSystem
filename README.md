
# 📝 Candidate Registration System

A simple Java web application to register candidates using **Servlets**, **JSP**, **JDBC**, and **MySQL**. Designed with MVC structure and Bootstrap for UI styling.

---

## 🚀 Features

- ✅ Register candidate with name, email, phone, and qualification
- ✅ View all registered candidates in a responsive table
- ✅ Basic frontend validations (required fields, email, 10-digit phone)
- ✅ Email and Phone must be unique
- ✅ Success message on successful registration
- ✅ Error message when trying to register duplicate email or phone
- ✅ Clean MVC architecture
- ✅ Works on Apache Tomcat with MySQL database

---

## 🧱 Tech Stack

- Java EE (Servlets & JSP)
- JDBC (MySQL Connector)
- MySQL (Backend DB)
- HTML5 + CSS3 + Bootstrap 4
- Apache Tomcat 9/10
- Eclipse IDE

---

## 📁 Project Structure (MVC)

```
CandidateRegistrationSystem/
├── src/
│   └── com/candidate/
│       ├── controller/
│       │   └── RegisterServlet.java
│       ├── dao/
│       │   └── CandidateDAO.java
│       └── model/
│           └── Candidate.java
├── WebContent/
│   ├── index.jsp
│   ├── view_candidates.jsp
│   └── WEB-INF/
│       └── web.xml
```

---

## 🧪 MySQL Table Script

```sql
CREATE DATABASE IF NOT EXISTS candidate_db;

USE candidate_db;

CREATE TABLE IF NOT EXISTS candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL UNIQUE,
    qualification VARCHAR(100) NOT NULL
);
```

---

## ⚙️ Setup & Installation

### ✅ Prerequisites

- Eclipse IDE for Enterprise Java Developers
- Apache Tomcat (v9 or later)
- MySQL Server (running locally)
- MySQL JDBC Driver (`mysql-connector-j-9.1.0.jar`)

### 🧩 Steps

1. **Clone or download the project**

```bash
git clone https://github.com/samarthhitnalli/CandidateRegistrationSystem.git
```

2. **Open in Eclipse**
   - File → Import → `Existing Projects into Workspace`
   - Choose project folder and click Finish

3. **Add MySQL JDBC JAR**
   - Download the MySQL JDBC driver [mysql-connector-j-9.1.0.jar](https://dev.mysql.com/downloads/connector/j/) if you haven't already.
   - Copy the JAR file into the following directory of your project:
        `CandidateRegistrationSystemJAVA/src/main/webapp/WEB-INF/lib/`


4. **Configure Tomcat**
   - Add Apache Tomcat server in Eclipse
   - Right-click Project → Run on Server

5. **Database Configuration**
   - Make sure MySQL is running
   - Use above SQL script to create DB and table

6. **Access the App**
   - Navigate to: `http://localhost:8080/CandidateRegistrationSystem/`

---

## 🔐 Validations

- All fields are required
- Email must follow proper format
- Phone must be 10 digits
- Prevents duplicate email or phone entries using `UNIQUE` constraints and backend checks

---

## 💡 Future Enhancements

- Add update/delete functionality for candidates
- Add login/authentication
- Pagination and search for viewing candidates

---

## 🛠️ Challenges Faced

- Configuring JDBC driver export in Eclipse
- Handling duplicate constraint errors with proper user-friendly messages
- Learning and implementing MVC pattern with JSP & Servlets

---

## 👨‍💻 Author

**Samarth Hitnalli**  
GitHub: [samarthhitnalli](https://github.com/samarthhitnalli)

---

## 📄 License

This project is open-source and free to use.
