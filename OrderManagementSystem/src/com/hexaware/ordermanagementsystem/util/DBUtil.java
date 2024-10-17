package com.hexaware.ordermanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ordersystem";
    private static final String USER = "root";
    private static final String PASS = "Sakshi@60#"; // Corrected password

    public static Connection getDBConn() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
