> 🔗 See `.copilot/instructions.md` for coding and architectural conventions.

# /.copilot/context.md

## Project Summary

A Java Spring Boot microservice implementing the OCPP 2.1 Central System Management System (CSMS).
It facilitates secure, bidirectional WebSocket communication between EV chargers and the central backend.
Primary goal: manage sessions, transactions, and charger state following the OCPP 2.1 specification.

---

## Core Components

* **WebSocket Endpoint:** `/ocpp/csms` — handles OCPP 2.1 messages from chargers.
* **OCPP Handler Layer:** Processes BootNotification, Heartbeat, Authorize, StartTransaction, StopTransaction, and StatusNotification.
* **Persistence Layer:** Stores charger info, active sessions, and transaction data in PostgreSQL.
* **REST API (Optional):** Provides administrative endpoints for system monitoring.
* **Error Handling:** Centralized exception handling for WebSocket and REST layers.

---

## Technology Stack

* **Language:** Java 17+
* **Framework:** Spring Boot
* **Protocol Library:** Java-OCA-OCPP
* **Database:** PostgreSQL (H2 for dev)
* **Build Tool:** Gradle
* **Monitoring:** Prometheus + Grafana
* **Logging:** SLF4J + Logback
* **Testing:** JUnit 5 + Testcontainers
* **Resilience:** Resilience4j
* **Security:** TLS and JWT-based authentication

---

## Domain Model

* **Charger:** Represents a physical charging station (identified by `stationId`).
* **Session:** Represents an active charging connection with a charger.
* **Transaction:** Represents energy usage and billing information for a session.
* **OcppMessage:** JSON-based message representing communication between CSMS and charger.

---

## Coding Conventions

* Package base: `com.example.ocpp`
* Use `@Service` for business logic and `@Controller` for WebSocket/REST layers.
* Constructor-based dependency injection.
* Use SLF4J for logging.
* Follow OCPP 2.1 message naming conventions.
* Store configurations in `application.yml`.
* Write JUnit 5 tests for all critical services.

---

## Key Design Notes

* Maintain a mapping of connected chargers via in-memory cache (use Guava or Redis).
* Ensure non-blocking message handling with async processing.
* Validate all inbound OCPP messages before persistence.
* Use DTOs for API request/response models.
* Publish internal events (e.g., transaction started/stopped) via Kafka if integrated.
* Future support: Diagnostics, Firmware Updates, and OCPI integration.

---

## Example Commands for Copilot Agent

* “Add BootNotification message handler implementing OCPP 2.1 spec.”
* “Create WebSocket controller for `/ocpp/csms` endpoint.”
* “Implement PostgreSQL repository for storing charger sessions.”
* “Add TLS configuration for secure WebSocket communication.”
* “Write integration test using Testcontainers for OCPP handler.”

---
