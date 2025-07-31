# Bank Microservices

This project contains two microservices for a bank:

1. **Account Microservice** - Handles account operations
2. **Loan Microservice** - Handles loan operations

## Architecture

```
┌─────────────────┐    ┌─────────────────┐
│   Account       │    │    Loan         │
│  Microservice   │    │  Microservice   │
│   Port: 8080    │    │   Port: 8081    │
└─────────────────┘    └─────────────────┘
```

## Services

### Account Service
- **Port**: 8080
- **Endpoint**: GET /accounts/{number}
- **Sample URL**: http://localhost:8080/accounts/00987987973432

### Loan Service
- **Port**: 8081
- **Endpoint**: GET /loans/{number}
- **Sample URL**: http://localhost:8081/loans/H00987987972342

## Quick Start

### Build All Services
```bash
# Build Account service
cd account
mvn clean package

# Build Loan service
cd ../loan
mvn clean package
```

### Run All Services

#### Terminal 1 - Account Service
```bash
cd account
mvn spring-boot:run
```

#### Terminal 2 - Loan Service
```bash
cd loan
mvn spring-boot:run
```

### Test Services

#### Account Service
```bash
curl http://localhost:8080/accounts/00987987973432
```

Expected Response:
```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343
}
```

#### Loan Service
```bash
curl http://localhost:8081/loans/H00987987972342
```

Expected Response:
```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```

## Project Structure
```
microservices/
├── account/              # Account Microservice
│   ├── src/
│   ├── pom.xml
│   └── README.md
├── loan/                 # Loan Microservice
│   ├── src/
│   ├── pom.xml
│   └── README.md
└── README.md             # This file
```

## Technologies Used
- Spring Boot 3.2.2
- Spring Web
- Spring Boot DevTools
- Maven
- Java 17

## Notes
- Each microservice is completely independent
- Services run on different ports to avoid conflicts
- No database connectivity - returns dummy data
- Both services can be run simultaneously
