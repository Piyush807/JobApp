# 💼 JobApp REST API

A clean, production-ready **RESTful backend** for managing job postings — built with **Spring Boot**, **PostgreSQL**, and **JPA/Hibernate**. Supports full CRUD operations, keyword search, and AOP-based logging.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4.0.3 |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Boilerplate Reduction | Lombok |
| Logging | AOP (AspectJ) + SLF4J |
| Build Tool | Maven |

---

## 📁 Project Structure

```
JobAppRest/
├── src/
│   └── main/
│       ├── java/com/jobapprest/jobapprest/
│       │   ├── JobAppRestApplication.java     # Entry point
│       │   ├── JobRestController.java         # REST endpoints
│       │   ├── aop/
│       │   │   └── LoggingAspect.java         # AOP logging
│       │   ├── model/
│       │   │   └── JobPost.java               # Entity / data model
│       │   ├── repo/
│       │   │   └── JobRepo.java               # JPA Repository
│       │   └── service/
│       │       └── JobService.java            # Business logic
│       └── resources/
│           └── application.properties         # DB config
└── pom.xml
```

---

## ✨ Features

- 📋 **Get all job posts** — fetch every listing in the database
- 🔍 **Get job by ID** — retrieve a specific post by its unique ID
- ➕ **Add a job post** — create a new listing via JSON body
- ✏️ **Update a job post** — modify an existing listing and return the updated result
- 🗑️ **Delete a job post** — remove a listing by ID
- 🔎 **Keyword search** — search across job title and description simultaneously
- 📦 **Bulk load** — seed the database with 5 sample job postings instantly
- 🪵 **AOP Logging** — automatic method-level logging via Spring AOP without touching business logic

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/jobPosts` | Get all job listings |
| `GET` | `/jobPost/{postId}` | Get a job by ID |
| `POST` | `/jobPost` | Add a new job post |
| `PUT` | `/jobPost` | Update an existing job post |
| `DELETE` | `/jobPost/{postId}` | Delete a job post |
| `GET` | `/jobPosts/keyword/{keyword}` | Search jobs by keyword |
| `GET` | `/load` | Seed the DB with sample data |

> 🌐 CORS is enabled for `http://localhost:3000` (React frontend by default)

---

## 🗃️ Data Model — `JobPost`

```json
{
  "postId": 1,
  "postProfile": "Java Developer",
  "postDesc": "Must have good experience in core Java and advanced Java",
  "reqExperience": 2,
  "postTechStack": ["Core Java", "J2EE", "Spring Boot", "Hibernate"]
}
```

| Field | Type | Description |
|---|---|---|
| `postId` | `int` | Unique identifier (Primary Key) |
| `postProfile` | `String` | Job title / role name |
| `postDesc` | `String` | Job description |
| `reqExperience` | `int` | Required years of experience |
| `postTechStack` | `List<String>` | Technologies required for the role |

---

## ⚙️ Setup & Installation

### Prerequisites

- Java 25+
- Maven 3.8+
- PostgreSQL running locally

### 1. Clone the Repository

```bash
git clone https://github.com/Piyush807/JobApp.git
cd JobApp
```

### 2. Configure the Database

Open `src/main/resources/application.properties` and update with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> 💡 Make sure your PostgreSQL database exists before running the app. You can create it with:
> ```sql
> CREATE DATABASE your_db_name;
> ```

### 3. Build & Run

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The server starts at **`http://localhost:8080`**

### 4. Load Sample Data

Hit this endpoint once to seed the database with 5 sample job posts:

```
GET http://localhost:8080/load
```

---

## 🔎 Example Requests

**Search for jobs by keyword:**
```
GET http://localhost:8080/jobPosts/keyword/Java
```

**Add a new job post:**
```http
POST http://localhost:8080/jobPost
Content-Type: application/json

{
  "postId": 6,
  "postProfile": "DevOps Engineer",
  "postDesc": "Experience with CI/CD pipelines and cloud infrastructure",
  "reqExperience": 3,
  "postTechStack": ["Docker", "Kubernetes", "Jenkins", "AWS"]
}
```

---

## 🪵 AOP Logging

This project uses **Aspect-Oriented Programming** to log method calls without polluting business logic. Currently, the `getJobByid` method in `JobService` is intercepted and logged automatically via `LoggingAspect.java`.

To extend logging to all service methods, simply uncomment this line in `LoggingAspect.java`:

```java
// @Before("execution(* com.jobapprest.jobapprest.service.JobService.*(..))")
```

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 👨‍💻 Author

**Piyush** — [GitHub @Piyush807](https://github.com/Piyush807)