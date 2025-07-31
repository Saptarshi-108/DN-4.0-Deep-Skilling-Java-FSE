# Account Microservice

## Description
A Spring Boot microservice for handling bank account operations.

## Features
- GET /accounts/{number} - Get account details by account number

## Sample Response
```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343
}
```

## Build and Run

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build
```bash
mvn clean package
```

### Run
```bash
mvn spring-boot:run
```

The service will start on port 8080.

### Test
Open browser and navigate to:
```
http://localhost:8080/accounts/00987987973432
```

## Project Structure
```
account/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/account/
│   │   │       ├── AccountApplication.java
│   │   │       ├── controller/
│   │   │       │   └── AccountController.java
│   │   │       └── model/
│   │   │           └── Account.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/cognizant/account/
│               └── AccountApplicationTests.java
└── pom.xml
```
