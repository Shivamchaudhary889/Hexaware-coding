package com.hexaware.ordermanagementsystem.dao;

import com.hexaware.ordermanagementsystem.util.DBUtil;
import com.hexaware.ordermanagementsystem.entity.Product;
import com.hexaware.ordermanagementsystem.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class OrderProcessor implements IOrderManagementRepository {

    @Override
    public void createOrder(User user, List<Product> products) throws Exception {
        Connection conn = DBUtil.getDBConn();
        // Logic to create order in the database
        // Loop through products and insert orderId for each product
    }

    @Override
    public void cancelOrder(int userId, int orderId) throws Exception {
        Connection conn = DBUtil.getDBConn();
        // Logic to cancel order based on userId and orderId
    }

    @Override
    public void createProduct(User user, Product product) throws Exception {
        if (!user.getRole().equals("Admin")) {
            throw new Exception("Only Admin can create products");
        }
        Connection conn = DBUtil.getDBConn();
        // Logic to insert a new product into the database
    }

    @Override
    public void createUser(User user) throws Exception {
        Connection conn = DBUtil.getDBConn();
        // Logic to create a new user in the database
    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        Connection conn = DBUtil.getDBConn();
        // Logic to fetch all products from the database
        return null;
    }

    @Override
    public List<Product> getOrderByUser(User user) throws Exception {
        Connection conn = DBUtil.getDBConn();
        // Logic to fetch all orders for a specific user
        return null;
    }
}
