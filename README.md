# Employee Management System REST API

A comprehensive, production-ready RESTful API for managing employee data, built with Spring Boot and implementing enterprise-grade security, validation, and documentation features.

## 🚀 Features

- **Full CRUD Operations** - Create, Read, Update, and Delete employee records
- **Role-Based Access Control (RBAC)** - Secure endpoints with EMPLOYEE, MANAGER, and ADMIN roles
- **HTTP Basic Authentication** - Secure API access with database-backed user management
- **Request Validation** - Comprehensive input validation using Jakarta Bean Validation
- **API Documentation** - Interactive Swagger/OpenAPI documentation
- **Database Integration** - JPA/Hibernate with H2 in-memory database
- **Custom Security Configuration** - Flexible authentication with custom database schema support
- **RESTful Design** - Follows REST principles with proper HTTP status codes
- **Exception Handling** - Custom authentication entry point with JSON error responses

## 🛠️ Technologies & Frameworks

### Core Framework
- **Spring Boot 4.0.2** - Latest Spring Boot framework for rapid application development
- **Java 17** - Modern Java with latest language features
- **Maven** - Dependency management and build automation

### Spring Modules
- **Spring Web MVC** - RESTful web services and MVC architecture
- **Spring Data JPA** - Data persistence layer with JPA/Hibernate
- **Spring Security** - Authentication and authorization framework
- **Spring Boot DevTools** - Development-time productivity tools
- **Spring Boot Validation** - Jakarta Bean Validation integration

### Database & Persistence
- **H2 Database** - In-memory relational database for development
- **Hibernate/JPA** - Object-Relational Mapping (ORM) framework
- **JPA Repository Pattern** - Data access abstraction layer

### API Documentation
- **SpringDoc OpenAPI 3.0.1** - OpenAPI 3.0 specification and Swagger UI integration
- **Swagger UI** - Interactive API documentation and testing interface

### Security & Validation
- **Spring Security** - Enterprise security framework
- **JdbcUserDetailsManager** - Database-backed user authentication
- **Jakarta Bean Validation** - Input validation annotations (@NotBlank, @Email, @Size, @Min)
- **Custom Authentication Entry Point** - JSON-based error responses

### Development Tools
- **Spring Boot Test** - Testing framework integration
- **JUnit 5** - Unit and integration testing

## 📋 API Endpoints

All endpoints are prefixed with `/api/employees` and require authentication.

| Method | Endpoint | Description | Required Role |
|--------|----------|-------------|---------------|
| `GET` | `/api/employees` | Get all employees | EMPLOYEE |
| `GET` | `/api/employees/{id}` | Get employee by ID | EMPLOYEE |
| `POST` | `/api/employees` | Create new employee | MANAGER |
| `PUT` | `/api/employees/{id}` | Update employee | MANAGER |
| `DELETE` | `/api/employees/{id}` | Delete employee | ADMIN |

### Public Endpoints
- `/docs` - Swagger UI documentation
- `/h2-console` - H2 Database Console

## 🔐 Security Architecture

### Role-Based Access Control
- **EMPLOYEE Role**: Read-only access (GET operations)
- **MANAGER Role**: Read and write access (GET, POST, PUT operations)
- **ADMIN Role**: Full access including delete operations (GET, POST, PUT, DELETE)

### Authentication
- **HTTP Basic Authentication** - Standard HTTP authentication mechanism
- **Database-Backed User Management** - Custom `system_users` and `roles` tables
- **Custom SQL Queries** - Flexible user and authority lookup queries
- **Custom Authentication Entry Point** - JSON error responses for unauthorized access

## 🏗️ Architecture

This project follows **layered architecture** principles:

```
┌─────────────────────────────────────┐
│      Controller Layer (REST)        │
│   EmployeeRestController.java        │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│        Service Layer                │
│   EmployeeService/ServiceImpl        │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│      Repository Layer (DAO)         │
│   EmployeeRepository (JPA)          │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│      Entity Layer                   │
│   Employee (JPA Entity)             │
└─────────────────────────────────────┘
```

### Design Patterns Implemented
- **Repository Pattern** - Data access abstraction
- **Service Layer Pattern** - Business logic separation
- **DTO Pattern** - Request/Response objects (EmployeeRequest)
- **Dependency Injection** - Constructor-based injection
- **Bean Configuration** - Java-based configuration classes

## 📁 Project Structure

```
employees/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/employeeProject/employees/
│   │   │       ├── controller/          # REST Controllers
│   │   │       │   └── EmployeeRestController.java
│   │   │       ├── service/             # Business Logic Layer
│   │   │       │   ├── EmployeeService.java
│   │   │       │   └── EmployeeServiceImpl.java
│   │   │       ├── dao/                 # Data Access Layer
│   │   │       │   └── EmployeeRepository.java
│   │   │       ├── entity/              # JPA Entities
│   │   │       │   └── Employee.java
│   │   │       ├── request/             # DTOs/Request Objects
│   │   │       │   └── EmployeeRequest.java
│   │   │       ├── security/            # Security Configuration
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── SwaggerConfig.java
│   │   │       └── EmployeesApplication.java
│   │   └── resources/
│   │       ├── application.properties.example
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/employeeProject/employees/
│               └── EmployeesApplicationTests.java
├── pom.xml                              # Maven Configuration
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Maven 3.6+**
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd employees
   ```

2. **Configure application properties**
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Edit `application.properties` and set your database password.

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or run the `EmployeesApplication` class directly from your IDE.

5. **Access the application**
   - **API Base URL**: `http://localhost:8080/api/employees`
   - **Swagger UI**: `http://localhost:8080/docs`
   - **H2 Console**: `http://localhost:8080/h2-console`

### Database Setup

The application uses H2 in-memory database. To use custom user authentication tables, create the following schema:

```sql
CREATE TABLE system_users (
  user_id VARCHAR(50) NOT NULL,
  password CHAR(68) NOT NULL,
  active BOOLEAN NOT NULL,
  PRIMARY KEY (user_id)
);
  
  
CREATE TABLE roles (
  user_id VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL,
  UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES system_users (user_id)
);
```

## 🧪 Testing

Run tests using Maven:
```bash
mvn test
```

## 📚 API Documentation

Once the application is running, access the interactive Swagger UI at:
- **URL**: `http://localhost:8080/docs`

The Swagger UI provides:
- Complete API endpoint documentation
- Request/Response schemas
- Try-it-out functionality
- Authentication support (Basic Auth)

## 🔧 Configuration

### Application Properties
Key configuration options in `application.properties`:
- Database connection settings
- H2 console configuration
- JPA/Hibernate settings
- Swagger UI path configuration

### Security Configuration
Security settings are configured in `SecurityConfig.java`:
- Role-based endpoint access
- HTTP Basic Authentication
- Custom authentication entry point

## 💡 Key Highlights

- ✅ **Modern Java Development** - Java 17 with latest Spring Boot 4.0.2
- ✅ **Enterprise Security** - Role-based access control with database authentication
- ✅ **RESTful Best Practices** - Proper HTTP methods, status codes, and resource naming
- ✅ **Input Validation** - Comprehensive validation with meaningful error messages
- ✅ **API Documentation** - Auto-generated OpenAPI/Swagger documentation
- ✅ **Clean Architecture** - Separation of concerns with layered architecture
- ✅ **Production-Ready** - Exception handling, transaction management, and security
- ✅ **Developer Experience** - DevTools, H2 console, and comprehensive documentation


---

**Built with ❤️ using Spring Boot**

