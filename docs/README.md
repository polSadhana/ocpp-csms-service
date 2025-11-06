# OCPP 2.1 CSMS Microservice

A microservice implementing an **OCPP 2.1 Central System Management System (CSMS)** using **Java, Spring Boot, and Java-OCA-OCPP**.
This service enables communication between EV charging stations and the central management platform.

---

## 🚀 Features

* WebSocket endpoint for OCPP 2.1 communication
* Parsing and handling of OCPP messages
* Persistence of charger state, sessions, and transactions
* Optional REST API for management and monitoring
* Secure and scalable architecture ready for production use

---

## 🧰 Tech Stack

| Layer            | Technology                            |
| ---------------- | ------------------------------------- |
| Language         | Java 17+                              |
| Framework        | Spring Boot                           |
| Protocol Library | Java-OCA-OCPP                         |
| Build Tool       | Gradle                                |
| Database         | PostgreSQL (H2 for local development) |
| Monitoring       | Prometheus + Grafana (recommended)    |
| Logging          | SLF4J + Logback                       |

---

## 🏗️ Architecture Overview

**Components:**

* **WebSocket Server:**
  Handles charger connections at `/ocpp/csms`.
* **OCPP Handler:**
  Parses and processes incoming OCPP 2.1 messages (e.g., BootNotification, Heartbeat, StartTransaction).
* **Persistence Layer:**
  Stores charger details, session history, and transaction data.
* **REST API (Optional):**
  Provides endpoints for administration, health checks, and monitoring.

---

## 🧭 Recommended Best Practices

* **Logging & Monitoring:** Use SLF4J/Logback, Prometheus, and Grafana.
* **Error Handling:** Implement centralized exception handling for WebSocket and REST layers.
* **Validation:** Validate OCPP message payloads for schema and logic.
* **Security:**

    * Enforce TLS for WebSocket connections.
    * Implement authentication (e.g., JWT or API keys).
* **Scalability:** Use stateless service design; externalize session state via Redis if needed.
* **Testing:**

    * Unit Tests: JUnit 5
    * Integration Tests: Testcontainers
* **Documentation:**
  Use OpenAPI/Swagger for REST APIs and document key OCPP workflows.
* **CI/CD:** Automate with GitHub Actions or Jenkins.
* **Configuration Management:**
  Use Spring profiles, Config Server, or Vault.
* **Resilience:** Add retry, timeout, and circuit breaker logic with Resilience4j.

---

## ⚙️ Getting Started

1. Clone the repository

   ```bash
   git clone https://github.com/your-org/ocpp-csms.git
   cd ocpp-csms
   ```

2. Build the project

   ```bash
   ./gradlew build
   ```

3. Run the application

   ```bash
   ./gradlew bootRun
   ```

4. Chargers connect via WebSocket:

   ```
   ws://<host>:<port>/ocpp/csms
   ```

---

## 🔧 Configuration

Update `src/main/resources/application.yml` for:

* Database connection (PostgreSQL or H2)
* Server ports
* Security and logging options

---

## 🧪 Testing

Run all tests:

```bash
./gradlew test
```

Integration tests with Testcontainers can be run locally with Docker installed.

---

## 📄 License

This project is licensed under the **MIT License**.
See [LICENSE](./LICENSE) for details.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
Open a PR or issue on GitHub.

---
