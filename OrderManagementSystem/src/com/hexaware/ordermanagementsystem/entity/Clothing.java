package com.hexaware.ordermanagementsystem.entity;


public class Clothing extends Product {
    private String size;
    private String color;

    // Constructor
    public Clothing(int productId, String productName, String description, double price, int quantityInStock, String type, String size, String color) {
        super(productId, productName, description, price, quantityInStock, type);
        this.size = size;
        this.color = color;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
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
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
    }
}
