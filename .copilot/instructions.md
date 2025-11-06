> 📘 See `.copilot/context.md` for project architecture, domain model, and terminology.

# /.copilot/instructions.md

## Purpose

These instructions guide GitHub Copilot’s behavior when generating or editing code in this repository.
They ensure all code contributions remain consistent with the project’s architecture, coding standards, and OCPP 2.1 requirements.

---

## General Guidelines

* Follow **clean architecture principles** — keep WebSocket controllers thin, delegate business logic to services.
* Use **Java 17 features** (records, switch expressions, etc.) when appropriate.
* Use **Spring Boot best practices**:

    * Use `@Configuration` for configuration classes.
    * Use `@Service`, `@Controller`, and `@Repository` appropriately.
    * Prefer constructor injection.
* Avoid hard-coded values — externalize configs to `application.yml`.
* Write **concise, well-documented code** with clear naming and Javadoc for public methods.
* Include **unit tests** for all new functionality.

---

## WebSocket and OCPP Handling

* WebSocket endpoint: `/ocpp/csms`
* Use Spring’s `WebSocketHandler` or `@ServerEndpoint` with JSON serialization (Jackson).
* Follow **OCPP 2.1 JSON message structure** (Action + Payload).
* Each OCPP message type (e.g., BootNotification, Heartbeat, StartTransaction) should have its own handler class implementing a common interface, e.g.:

  ```java
  public interface OcppMessageHandler<T> {
      void handleMessage(T message, String stationId);
  }
  ```
* Validate messages before processing; log invalid ones with reason codes.

---

## Persistence Layer

* Use **Spring Data JPA** for persistence.
* Use PostgreSQL for production and H2 for local testing.
* Entities should include `createdAt` and `updatedAt` timestamps.
* Use Liquibase or Flyway for schema versioning.

---

## Security and Communication

* Always use **TLS/HTTPS** for WebSocket connections.
* Implement **JWT authentication** for chargers.
* Avoid exposing internal endpoints publicly.
* Mask sensitive data in logs.

---

## Event Handling and Messaging

* Use **Kafka** for event publishing if required.
* Kafka topics should follow naming:
  `ocpp.<message_type>.<event>` (e.g., `ocpp.transaction.start`)
* Implement idempotency in message handling to prevent duplicate transactions.

---

## Testing and Quality

* Write **JUnit 5** tests for all new handlers and services.
* Use **Testcontainers** for integration testing with PostgreSQL and Kafka.
* Mock WebSocket connections where applicable.
* Maintain test coverage above 80%.

---

## Observability

* Expose metrics via **Micrometer + Prometheus**.
* Include `@Timed` and `@Counted` annotations for key business operations.
* Provide a `/health` endpoint for liveness and readiness checks.

---

## Code Style and Review

* Follow standard Java formatting (Google Style or default IntelliJ).
* Keep methods small and single-responsibility.
* Use `Optional` for nullable returns.
* Prefer immutability where possible.

---

## Example Prompts for Copilot

* “Add a handler for the BootNotification OCPP 2.1 message.”
* “Implement a service to manage charger sessions using Guava Cache.”
* “Add JWT-based authentication for WebSocket connections.”
* “Refactor StartTransactionHandler to use asynchronous message processing.”
* “Create an integration test for Heartbeat message flow using Testcontainers.”

---

## Notes

* Reference `.copilot/context.md` for domain model and technology stack.
* When generating code, ensure all class names and package structures match the conventions listed there.

---
