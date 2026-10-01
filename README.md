# 🛒 Hibernate E-Commerce Management System

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Hibernate](https://img.shields.io/badge/Hibernate-6.6-blue?style=for-the-badge&logo=hibernate)
![MySQL](https://img.shields.io/badge/MySQL-8.4-blue?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.9-red?style=for-the-badge&logo=apachemaven)
![JUnit](https://img.shields.io/badge/JUnit-5-green?style=for-the-badge&logo=junit5)

</p>

## 📌 About the Project

This project is a **Java-based E-Commerce Management System** developed using **Hibernate ORM, JPA, Maven, and MySQL**.

The system demonstrates how Java objects can be mapped to relational database tables using Hibernate and JPA annotations.

The project contains five main entities:

- Category
- Product
- Users
- Orders
- OrderDetails

---

## ✨ Features

| Feature | Status |
|---|---|
| Category Management | ✅ |
| Product Management | ✅ |
| User Management | ✅ |
| BCrypt Password Hashing | ✅ |
| Order Creation | ✅ |
| Multiple Order Details | ✅ |
| Order Retrieval | ✅ |
| Product Update | ✅ |
| Order Deletion | ✅ |
| MySQL Persistence | ✅ |
| JUnit Testing | ✅ |

---

## 🏗️ Entity Relationships

```text
                 ┌───────────────┐
                 │   Category    │
                 └───────┬───────┘
                         │
                       1 │
                         │
                         │ *
                 ┌───────▼───────┐
                 │    Product    │
                 └───────┬───────┘
                         │
                       1 │
                         │ *
                ┌────────▼─────────┐
                │   OrderDetails   │
                └────────┬─────────┘
                         │ *
                         │
                         │ 1
                 ┌───────▼───────┐
                 │     Orders    │
                 └───────┬───────┘
                         │
                       * │
                         │ 1
                 ┌───────▼───────┐
                 │     Users     │
                 └───────────────┘