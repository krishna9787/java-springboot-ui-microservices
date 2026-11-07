# eCommerce Microservices

This repository contains a Java-based microservices architecture for an e-commerce platform. Each service is implemented as an independent Spring Boot application and focuses on one domain area of the business.

## Overview

The project is organized into the following services:

- `user` – user accounts and profile management
- `products` – product catalog and item details
- `inventory` – stock levels and product availability
- `cart` – shopping cart behavior and cart items
- `order` – order creation and order lifecycle
- `payment` – payment processing and transaction handling
- `shipping` – shipping and delivery operations
- `notification` – email, SMS, and notification workflows
- `search` – search and query capabilities over catalog data
- `promotion` – discounts, offers, and promotion logic

## Tech Stack

- Java 17
- Spring Boot 4.1.0
- Maven
- Spring Web MVC
- Spring Data JPA
- H2 database for local development
- Spring Boot Actuator
- Kafka support in some services for asynchronous messaging

## Repository Layout

```text
.
├── cart
├── inventory
├── notification
├── order
├── payment
├── products
├── promotion
├── search
├── shipping
├── user
└── README.md
```

Each folder is a Maven project with its own `pom.xml` and application entry point.

## Prerequisites

Before running the services, make sure you have:

- Java 17 or later
- Maven installed and available on your `PATH`
- An IDE such as IntelliJ IDEA or VS Code, or a terminal environment for running Maven commands

## Running a Service

From any service directory, run:

```bash
mvn clean install
mvn spring-boot:run
```

You can also run a specific service directly in your IDE by launching its main Spring Boot class.

## Development Notes

- Services are designed to be independently deployable.
- Local development uses embedded H2 database configuration unless a service is configured otherwise.
- Some modules include Kafka-related dependencies, which may be used for asynchronous communication between services.
- Actuator endpoints are available for health and operational checks through Spring Boot Actuator.

## Suggested Workflow

1. Start the service dependencies you need for the scenario.
2. Run the required domain services individually.
3. Use the application endpoints to test cart, order, payment, and shipping flows.
4. Validate health and logs through Actuator endpoints and application logs.

## License

This project currently does not include a specific license file. Add a license if your team needs one for distribution or production use.
