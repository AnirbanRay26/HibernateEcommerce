<div align="center">

# 🛒 Hibernate E-Commerce Management System

### Java + Hibernate ORM + MySQL

**Developed by Anirban Ray**  
**B.Tech Computer Science & Engineering**

<p>
<img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk">
<img src="https://img.shields.io/badge/Hibernate-ORM-blue?style=for-the-badge">
<img src="https://img.shields.io/badge/JPA-3.1-red?style=for-the-badge">
<img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven">
<img src="https://img.shields.io/badge/JUnit-5-green?style=for-the-badge&logo=junit5">
</p>

</div>

---

## 📌 Project Overview

This project is a **Hibernate ORM based E-Commerce Management System** developed using Java and MySQL.

The application demonstrates:

- Hibernate ORM and JPA annotations
- Entity relationships
- CRUD operations
- Order and order-detail management
- MySQL database persistence
- BCrypt password hashing
- HQL fetching
- JUnit testing

---

## 👨‍💻 Developer

### **Anirban Ray**

**B.Tech Computer Science & Engineering**

This project was developed as part of an academic Hibernate ORM implementation assignment.

---

## 🎯 Project Objective

The main objective is to implement an e-commerce database system using **Hibernate ORM** and demonstrate proper entity mapping, relationships, persistence, CRUD operations, and database interaction.

---

## ✨ Key Features

| Feature | Implementation |
|---|---|
| Category Management | Create and store categories |
| Product Management | Products linked with categories |
| User Management | Customer/Admin users |
| Order Management | Orders linked with users |
| Order Details | Multiple products per order |
| CRUD Operations | Create, Read, Update and Delete |
| ORM Mapping | JPA/Hibernate annotations |
| Password Security | BCrypt hashing |
| Database | MySQL |
| Testing | JUnit 5 |

---

## 🏗️ Entity Relationships

```text
Category
   │
   └── 1 : Many ──> Product

Users
   │
   └── 1 : Many ──> Orders
                         │
                         └── 1 : Many ──> OrderDetails
                                               │
                                               └── Many : 1 ──> Product