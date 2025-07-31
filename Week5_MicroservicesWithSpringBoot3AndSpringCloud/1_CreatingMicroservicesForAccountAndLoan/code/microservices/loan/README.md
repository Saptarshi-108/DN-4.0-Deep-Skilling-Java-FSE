# Loan Microservice

## Description
A Spring Boot microservice for handling bank loan operations.

## Features
- GET /loans/{number} - Get loan details by loan number

## Sample Response
```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
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

The service will start on port 8081.

### Test
Open browser and navigate to:
```
http://localhost:8081/loans/H00987987972342
```

## Project Structure
```
loan/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/loan/
│   │   │       ├── LoanApplication.java
│   │   │       ├── controller/
│   │   │       │   └── LoanController.java
│   │   │       └── model/
│   │   │           └── Loan.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/cognizant/loan/
│               └── LoanApplicationTests.java
└── pom.xml
```

## Note
This service runs on port 8081 to avoid conflicts with the Account service which runs on port 8080.
