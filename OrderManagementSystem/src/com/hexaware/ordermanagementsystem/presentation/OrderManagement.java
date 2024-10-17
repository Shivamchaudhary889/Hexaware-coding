package com.hexaware.ordermanagementsystem.presentation;

import com.hexaware.ordermanagementsystem.dao.OrderProcessor;
import com.hexaware.ordermanagementsystem.entity.Clothing;
import com.hexaware.ordermanagementsystem.entity.Electronics;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderProcessor processor = new OrderProcessor();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nOrder Management System Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Cancel Order");
            System.out.println("4. Get All Products");
            System.out.println("5. Get Orders by User");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createUser(scanner, processor);
                    break;
                case 2:
                    createProduct(scanner, processor);
                    break;
                case 3:
                    cancelOrder(scanner, processor);
                    break;
                case 4:
                    getAllProducts(processor);
                    break;
                case 5:
                    getOrderByUser(scanner, processor);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the Order Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void createUser(Scanner scanner, OrderProcessor processor) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (Admin/User): ");
        String role = scanner.nextLine();

        User user = new User(userId, username, password, role);
        try {
            processor.createUser(user);
            System.out.println("User created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    private static void createProduct(Scanner scanner, OrderProcessor processor) {
        System.out.print("Enter user ID (must be Admin to create product): ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity in stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product type (Electronics/Clothing): ");
        String type = scanner.nextLine();

        try {
            User admin = new User(userId, "", "", "Admin");  // Assuming admin user
            Product product = null;
            if (type.equalsIgnoreCase("Electronics")) {
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter warranty period (in months): ");
                int warrantyPeriod = scanner.nextInt();
                product = new Electronics(productId, productName, description, price, quantity, type, brand, warrantyPeriod);
            } else if (type.equalsIgnoreCase("Clothing")) {
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                product = new Clothing(productId, productName, description, price, quantity, type, size, color);
            }

            if (product != null) {
                processor.createProduct(admin, product);
                System.out.println("Product created successfully.");
            } else {
                System.out.println("Error: Unsupported product type.");
            }
        } catch (Exception e) {
            System.out.println("Error creating product: " + e.getMessage());
        }
    }

    private static void cancelOrder(Scanner scanner, OrderProcessor processor) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter order ID to cancel: ");
        int orderId = scanner.nextInt();
        try {
            processor.cancelOrder(userId, orderId);
            System.out.println("Order canceled successfully.");
        } catch (Exception e) {
            System.out.println("Error canceling order: " + e.getMessage());
        }
    }

    private static void getAllProducts(OrderProcessor processor) {
        try {
            List<Product> products = processor.getAllProducts();
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
                    System.out.println(product.getProductId() + ": " + product.getProductName() + " (" + product.getType() + ")");
                }
            } else {
                System.out.println("No products available.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }
    }

    private static void getOrderByUser(Scanner scanner, OrderProcessor processor) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = new User(userId, username, "", "User");  // Assuming "User" role

        try {
            List<Product> orders = processor.getOrderByUser(user);
            if (orders != null && !orders.isEmpty()) {
                System.out.println("Orders placed by " + user.getUsername() + ":");
                for (Product order : orders) {
                    System.out.println(order.getProductId() + ": " + order.getProductName());
                }
            } else {
                System.out.println("No orders found for user " + user.getUsername());
            }
        } catch (Exception e) {
            System.out.println("Error retrieving orders: " + e.getMessage());
        }
    }
}
