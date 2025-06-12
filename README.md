# Employee Management System (Spring Boot + MySQL)

A complete backend RESTful application built using **Java Spring Boot**, demonstrating CRUD operations, layered architecture, validation, exception handling, pagination, and security.

---

## Features

- Add / Update / Delete Employees
- Get employee by ID, filter by department
- Search employees by name
- Pagination and sorting
- Input validation with error messages
- Global exception handling
- Swagger UI for testing APIs
- Spring Security with login + role-based access

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Swagger (OpenAPI)
- Postman (for testing)

---

## Project Structure

com.roopak.employeeMngt
- rest // REST API
- service // Business logic
- repository // JPA interface
- entity // JPA entities
- exception // Custom error handling
- security // Security config

---

## Endpoints

| Method | Endpoint                             | Description                     |
|--------|--------------------------------------|---------------------------------|
| GET    | `/api/employees`                     | Get all employees               |
| GET    | `/api/employees/id/{id}`             | Get employee by ID              |
| POST   | `/api/employees`                     | Create new employee             |
| PUT    | `/api/employees/{id}`                | Update existing employee        |
| DELETE | `/api/employees/{id}`                | Delete employee                 |
| GET    | `/api/employees/search-by-name`      | Search employee by name         |
| GET    | `/api/employees/search-by-department` | Filter by department            |
| GET    | `/api/employees/paginated-sorted`    | Paginate and sort employee list |

---


## How to Run Locally

Create a database using given sql script - employee-mngt.sql, then

```bash
# Clone the repo
git clone https://github.com/roopakdureja/EMS.git

# Navigate to project directory
cd  employeeMngt-jpa 
```
Configure the application properties, then

```bash
# Run using Maven
./mvnw spring-boot:run
```

---

## Testing

- Run the app and visit: `http://localhost:8080/swagger-ui/index.html` for Swagger UI

---

## Author
Roopak Dureja<br>
www.linkedin.com/in/roopak-dureja 
<br>Date - June 12th, 2025