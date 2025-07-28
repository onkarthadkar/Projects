# Bookstore API

A modern, clean, and well-structured RESTful API built with Spring Boot, designed to manage books and authors. This backend service provides full CRUD operations, filtering, pagination, and sorting capabilities for book listings, along with input validation and DTO-based request and response modeling to ensure clean separation between internal data and external API contracts.

## Features

- Built with Spring Boot and Maven
- JPA (Hibernate) entities for `Book` and `Author`
- RESTful CRUD API endpoints for both entities
- Filtering by book title, pagination, and sorting on book lists
- DTO pattern for input/output decoupling
- Validation with Jakarta Bean Validation annotations (`@NotBlank`, `@NotNull`)
- Layered architecture: Entities, Repositories, Services, Controllers
- Global exception handling with meaningful HTTP responses
- Interactive Swagger/OpenAPI documentation
- In-memory H2 database for easy local testing and demo
- Unit and integration tests included

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git
- (Optional) Docker for containerized deployment
- (Optional) Postman for API testing

### Clone the repository

