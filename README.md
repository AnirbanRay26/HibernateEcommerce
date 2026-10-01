# Hibernate E-Commerce Management System

## About

This project is a Java-based E-Commerce Management System developed using Hibernate ORM, JPA, Maven and MySQL.

The project demonstrates object-relational mapping between:

- Category
- Product
- Users
- Orders
- OrderDetails

## Technologies

- Java 17
- Hibernate ORM
- JPA
- Maven
- MySQL
- BCrypt
- JUnit 5

## Relationships

- Category 1 ----- * Product
- Users 1 ----- * Orders
- Orders 1 ----- * OrderDetails
- Product 1 ----- * OrderDetails

## Features

- Category creation
- Product creation
- User creation
- BCrypt password hashing
- Order creation
- Multiple order details
- Order fetching
- Product update
- Database persistence
- JUnit testing

## Database

Database name:

`hibernate_ecommerce`

Configuration file:

`src/main/resources/hibernate.cfg.xml`

## Running the Project

1. Configure MySQL.
2. Set your local MySQL username and password in `hibernate.cfg.xml`.
3. Run `App.java`.

## Testing

Run `CrudTest.java` as a JUnit Test.

## Database Schema

SQL schema:

`database/schema.sql`