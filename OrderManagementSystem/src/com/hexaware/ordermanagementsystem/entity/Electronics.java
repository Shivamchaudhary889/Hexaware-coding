package com.hexaware.ordermanagementsystem.entity;



public class Electronics extends Product {
    private String brand;
    private int warrantyPeriod; // in months

    // Constructor
    public Electronics(int productId, String productName, String description, double price, int quantityInStock, String type, String brand, int warrantyPeriod) {
        super(productId, productName, description, price, quantityInStock, type);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    // Implementing the abstract method
    @Override
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
    }
}
