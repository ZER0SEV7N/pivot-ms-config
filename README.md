# Pivot Banking System - Config Server (`ms-config`)

## Overview
Centralized Configuration Microservice built with **Spring Cloud Config Server** and **Java 17**. It externalizes all environment properties (ports, MongoDB database URIs, inter-service endpoints, and logging levels) for the Pivot Banking System microservices.

## Architecture & Communication
- **Role:** Infrastructure Configuration Server.
- **Port:** `8888`
- **Database:** None (Stateless infrastructure service).
- **Clients that communicate with this service:**
    - `ms-customer`
    - `ms-account`
    - `ms-credit`
    - `ms-transaction`

## Tech Stack
- **Java 17**
- **Spring Boot 4.1.2**
- **Spring Cloud Config Server (2025.1.4)**
- **Logback** (Structured logging)
- **Maven**

## How to Run
1. Clone the repository:
   ```bash
    git clone https://github.com/ZER0SEV7N/pivot-ms-config.git
    cd pivot-ms-config
    ```

2. Build and run using Maven:
    ```bash
    mvn clean spring-boot:run
    ```


3. Verify the configurations are served properly via Postman (see attached Postman Collection JSON).

---