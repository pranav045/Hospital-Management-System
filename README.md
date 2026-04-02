# 🏥 Hospital Management System 

A backend-only Hospital Management System built with **Spring Boot** and **PostgreSQL**. It provides RESTful APIs to manage doctors, patients, and appointments with robust entity relationships and CRUD operations.

---

## 📦 Tech Stack
- **Spring Boot** – Java backend framework
- **PostgreSQL** – Relational database
- **Spring Data JPA** – ORM and repository layer
- **Maven** – Dependency management

---

## 🧩 Project Architecture

### 🔹 Entities
- **Doctor**: `id`, `name`, `specification`
- **Patient**: `id`, `name`, `disease`
- **Appointment**: `id`, `date`, `doctor`, `patient`  
  - Uses `@ManyToOne` for doctor and patient relationships

### 🔹 Layers
- **Repository Layer** – Interfaces extending `JpaRepository`
- **Service Layer** – Business logic
- **Controller Layer** – REST endpoints for CRUD

---

## 🚀 Features
- CRUD operations for Doctors, Patients, and Appointments
- Relational mapping with `@ManyToOne`
- Clean layered architecture
- DTOs and exception handling for robust API responses

---

## 📁 Project Structure

| Layer        | Responsibility                                                                 |
|--------------|---------------------------------------------------------------------------------|
| **Entity**   | Defines database tables using JPA annotations (`Doctor`, `Patient`, `Appointment`). |
| **Repository** | Spring Data abstraction (`JpaRepository`). Provides ready-made CRUD operations and query methods without boilerplate code. |
| **Service**  | Contains business logic, interacts with Repository, and manages entity relationships. |
| **Controller** | REST endpoints (`@RestController`) exposing APIs for Doctors, Patients, and Appointments. |
| **DTO**      | Data Transfer Objects for clean API request/response handling. |
| **Exception** | Centralized error handling with custom exceptions and `@ControllerAdvice`. |

---

## ⚙️ Setup Instructions
1. Clone the repository  
2. Configure `application.properties` with PostgreSQL credentials  
3. Run the app using `mvn spring-boot:run`  
4. Test APIs via Postman or browser  

---

## 📌 Future Enhancements
- Authentication & role-based access
- Swagger API documentation
- Integration with frontend (React/Angular)
