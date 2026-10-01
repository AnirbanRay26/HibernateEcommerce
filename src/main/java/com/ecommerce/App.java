package com.ecommerce;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.OrderDetails;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.Users;
import com.ecommerce.util.HibernateUtil;
import com.ecommerce.util.PasswordUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        try {
            // ====================================
            // CREATE CATEGORIES
            // ====================================
            Category electronics = new Category(
                    "Electronics",
                    "Electronic products"
            );

            Category books = new Category(
                    "Books",
                    "Books and study materials"
            );

            // ====================================
            // CREATE PRODUCTS
            // ====================================
            Product laptop = new Product(
                    "Laptop",
                    new BigDecimal("75000"),
                    10
            );

            Product phone = new Product(
                    "Smartphone",
                    new BigDecimal("30000"),
                    20
            );

            Product book = new Product(
                    "Java Programming Book",
                    new BigDecimal("900"),
                    50
            );

            // Connect products to categories
            electronics.addProduct(laptop);
            electronics.addProduct(phone);
            books.addProduct(book);

            // Save categories
            save(electronics);
            save(books);

            System.out.println("Categories and products saved.");

            // ====================================
            // CREATE USER
            // ====================================
            Users customer = new Users(
                    "customer1",
                    PasswordUtil.hashPassword("customer123"),
                    "customer1@gmail.com",
                    Role.CUSTOMER
            );

            save(customer);

            System.out.println("User saved.");

            // ====================================
            // CREATE ORDER
            // ====================================
            Orders order = new Orders(customer);

            // Laptop
            OrderDetails laptopDetail = new OrderDetails(
                    laptop,
                    1,
                    laptop.getPrice()
            );

            // Phone
            OrderDetails phoneDetail = new OrderDetails(
                    phone,
                    2,
                    phone.getPrice()
            );

            // Book
            OrderDetails bookDetail = new OrderDetails(
                    book,
                    3,
                    book.getPrice()
            );

            // Add all products to order
            order.addDetail(laptopDetail);
            order.addDetail(phoneDetail);
            order.addDetail(bookDetail);

            save(order);

            System.out.println("Order saved.");
            System.out.println(
                    "Order total = " + order.getTotalAmount()
            );

            // ====================================
            // FETCH ORDER
            // ====================================
            try (Session session =
                         HibernateUtil.getSessionFactory().openSession()) {

                Orders fetchedOrder = session.createQuery(
                        "select distinct o " +
                        "from Orders o " +
                        "join fetch o.user " +
                        "join fetch o.orderDetails d " +
                        "join fetch d.product " +
                        "where o.id = :id",
                        Orders.class
                )
                .setParameter("id", order.getId())
                .getSingleResult();

                System.out.println("\n===== ORDER =====");

                System.out.println(
                        "Order ID: " + fetchedOrder.getId()
                );

                System.out.println(
                        "Customer: " +
                        fetchedOrder.getUser().getUsername()
                );

                System.out.println(
                        "Total: " +
                        fetchedOrder.getTotalAmount()
                );

                System.out.println("\nProducts:");

                for (OrderDetails detail :
                        fetchedOrder.getOrderDetails()) {

                    System.out.println(
                            detail.getProduct().getName() +
                            " | Quantity: " +
                            detail.getQuantity() +
                            " | Price: " +
                            detail.getUnitPrice()
                    );
                }
            }

            // ====================================
            // UPDATE PRODUCT
            // ====================================
            try (Session session =
                         HibernateUtil.getSessionFactory().openSession()) {

                Transaction transaction =
                        session.beginTransaction();

                Product existingProduct =
                        session.find(Product.class, phone.getId());

                existingProduct.setPrice(
                        new BigDecimal("28000")
                );

                transaction.commit();
            }

            System.out.println("\nPhone price updated.");

            // ====================================
            // PASSWORD TEST
            // ====================================
            System.out.println(
                    "\nCorrect password: " +
                    PasswordUtil.checkPassword(
                            "customer123",
                            customer.getPassword()
                    )
            );

            System.out.println(
                    "Wrong password: " +
                    PasswordUtil.checkPassword(
                            "wrongpassword",
                            customer.getPassword()
                    )
            );
            
         // ====================================
         // DELETE ORDER
         // ====================================
         try (Session session =
                  HibernateUtil.getSessionFactory().openSession()) {

             Transaction transaction =
                     session.beginTransaction();

             Orders orderToDelete =
                     session.find(Orders.class, order.getId());

             if (orderToDelete != null) {
                 session.remove(orderToDelete);
             }

             transaction.commit();
         }

         System.out.println("Order deleted successfully.");
         
         System.out.println(
                 "\n===== PROJECT FINISHED ====="
         );

        } finally {
            HibernateUtil.shutdown();
        }
    }

    // ====================================
    // SAVE METHOD
    // ====================================
    private static void save(Object object) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction =
                    session.beginTransaction();

            session.persist(object);

            transaction.commit();
        }
    }
}