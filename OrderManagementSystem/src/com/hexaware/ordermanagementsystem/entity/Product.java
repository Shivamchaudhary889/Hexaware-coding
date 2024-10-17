package com.hexaware.ordermanagementsystem.entity;

public abstract class Product {
    protected int productId;
    protected String productName;
    protected String description;
    protected double price;
    protected int quantityInStock;
    protected String type;

    // Constructor
    public Product(int productId, String productName, String description, double price, int quantityInStock, String type) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.type = type;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public String getType() {
        return type;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();
}
