# Loans Service

## Description
This project is a resolution for the [Loans Challenge](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md) and implements a service that determines which loan types a customer is eligible for based on specific criteria such as age, income, and location.

## Technologies Used
- Java 17
- Spring Boot
- Spring Web
- Maven

## Business Rules
The available loan types for a customer are determined based on the following rules:

- **Personal Loan (4% interest rate)**
    - Available for customers with an income ≤ R$ 3000.
    - Available for customers with an income between R$ 3000 and R$ 5000, if they are under 30 years old and reside in São Paulo (SP).

- **Consignment Loan (2% interest rate)**
    - Available for customers with an income ≥ R$ 5000.

- **Guaranteed Loan (3% interest rate)**
    - Available for customers with an income ≤ R$ 3000.
    - Available for customers with an income between R$ 3000 and R$ 5000, if they are under 30 years old and reside in São Paulo (SP).

## Endpoints

### `POST /customer-loans`
**Description:** Determines which loans a customer is eligible for.

**Request Example:**
```json
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```

**Response Example:**
```json
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "PERSONAL",
            "interest_rate": 4
        },
        {
            "type": "GUARANTEED",
            "interest_rate": 3
        },
        {
            "type": "CONSIGNMENT",
            "interest_rate": 2
        }
    ]
}
```

**Request to return error Example:**
```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 4000.00,
  "location": "RJ"
}
```

**Response with error Example:**
```json
No loan found!
```

## How to Run the Project

### Using Maven
1. Clone the repository:
   ```sh
   git clone <REPOSITORY_URL>
   ```
2. Navigate to the project directory:
   ```sh
   cd loans-service
   ```
3. Compile and run the application:
   ```sh
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080/customer-loans`.

---

Developed by Lucas Bressiani

