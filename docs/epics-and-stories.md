# Project Epics and User Stories

## Epic 1: WebSocket OCPP 2.1 Communication
- **Story 1.1:** Set up Spring Boot WebSocket server at `/ocpp/csms`
- **Story 1.2:** Integrate Java-OCA-OCPP library for message parsing
- **Story 1.3:** Handle basic OCPP 2.1 message types (e.g., BootNotification, Heartbeat)
- **Story 1.4:** Implement error handling for WebSocket connections

## Epic 2: Persistence Layer
- **Story 2.1:** Configure PostgreSQL (and H2 for development)
- **Story 2.2:** Design entities for charger, session, and transaction data
- **Story 2.3:** Implement repositories for CRUD operations
- **Story 2.4:** Store and retrieve OCPP events

## Epic 3: REST API for Management & Monitoring
- **Story 3.1:** Scaffold REST controllers for charger/session management
- **Story 3.2:** Add endpoints for querying charger status and sessions
- **Story 3.3:** Document REST API with OpenAPI/Swagger

## Epic 4: Security & Validation
- **Story 4.1:** Enable TLS for WebSocket endpoint
- **Story 4.2:** Add authentication (JWT or API keys)
- **Story 4.3:** Validate incoming OCPP messages (schema & business rules)

## Epic 5: Observability & Resilience
- **Story 5.1:** Integrate SLF4J/Logback for logging
- **Story 5.2:** Add Prometheus metrics and Grafana dashboards
- **Story 5.3:** Implement retry, timeout, and circuit breaker patterns (Resilience4j)

## Epic 6: CI/CD & Configuration Management
- **Story 6.1:** Set up Gradle build and test pipelines (GitHub Actions/Jenkins)
- **Story 6.2:** Externalize configuration (Spring profiles, config server)
- **Story 6.3:** Add Testcontainers for integration testing

---

Each story can be tracked as a ticket in your project management tool.

