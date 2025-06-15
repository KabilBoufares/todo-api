# Todo API

A robust, production-ready RESTful API for managing Todo items, built with Spring Boot, PostgreSQL, and Docker. This project demonstrates best practices in API design, error handling, validation, and containerization.

---

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Error Handling](#error-handling)
- [Configuration](#configuration)
- [Development & Testing](#development--testing)
- [Docker & Deployment](#docker--deployment)

---

## Features

- **CRUD Operations:** Create, read, update, and delete todos.
- **Validation:** Input validation with clear error messages.
- **Exception Handling:** Global exception handler for consistent error responses.
- **OpenAPI/Swagger:** Interactive API documentation.
- **PostgreSQL Integration:** Persistent storage using a relational database.
- **Dockerized:** Ready for containerized deployment with Docker and Docker Compose.
- **Clean Architecture:** Separation of concerns with controllers, services, validators, and repositories.

---

## Architecture

- **Spring Boot:** Main application framework.
- **JPA/Hibernate:** ORM for database access.
- **Lombok:** Reduces boilerplate code.
- **PostgreSQL:** Relational database for persistent storage.
- **Docker:** Containerization for easy deployment.
- **Swagger/OpenAPI:** API documentation and testing.

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Docker (optional, for containerized setup)

### Local Development

1. **Clone the repository:**
   ```sh
   git clone <your-repo-url>
   cd todo-api
   ```

2. **Start PostgreSQL with Docker Compose:**
   ```sh
   docker-compose up -d db
   ```

3. **Build the project:**
   ```sh
   ./mvnw clean package
   ```

4. **Run the application:**
   ```sh
   java -jar target/todo-api-0.0.1-SNAPSHOT.jar
   ```
   The API will be available at [http://localhost:8082/api/todos](http://localhost:8082/api/todos).

### Running with Docker Compose

To run both the app and the database in containers:
```sh
docker-compose up --build
```
The API will be available at [http://localhost:8081/api/todos](http://localhost:8081/api/todos).

---

## API Reference

All endpoints are prefixed with `/api/todos`.

### Endpoints

- **GET `/api/todos`**  
  Retrieve all todos.

- **GET `/api/todos/{id}`**  
  Retrieve a todo by its ID.

- **POST `/api/todos`**  
  Create a new todo.  
  **Request Body:**
  ```json
  {
    "title": "string",
    "description": "string",
    "completed": false
  }
  ```

- **PUT `/api/todos/{id}`**  
  Update an existing todo.  
  **Request Body:**
  ```json
  {
    "title": "string",
    "description": "string",
    "completed": true
  }
  ```

- **DELETE `/api/todos/{id}`**  
  Delete a todo by its ID.

### Interactive Documentation

- Swagger UI:  
  [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html) (local)  
  [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) (Docker Compose)

---

## Error Handling

All errors are returned in a consistent format:
```json
{
  "error": "Error message here"
}
```
- **400 Bad Request:** Validation errors or malformed requests.
- **404 Not Found:** Todo not found.
- **500 Internal Server Error:** Unexpected server errors.

---

## Configuration

Main configuration is in [`src/main/resources/application.properties`](src/main/resources/application.properties):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=todo_user
spring.datasource.password=todo_pass
spring.jpa.hibernate.ddl-auto=update
server.port=8082
```

When running with Docker Compose, environment variables override these settings for container networking.

---

## Development & Testing

- **Unit and Integration Tests:**  
  Run all tests with:
  ```sh
  ./mvnw test
  ```

- **Code Quality:**  
  - Uses Lombok for boilerplate reduction.
  - Follows clean code and separation of concerns.

---

## Docker & Deployment

- **Dockerfile:**  
  Builds a lightweight image using OpenJDK 17.
- **docker-compose.yml:**  
  Orchestrates the app and PostgreSQL database.

**Build and run with Docker Compose:**
```sh
docker-compose up --build
```

---



## Author
Kabil Boufares 
