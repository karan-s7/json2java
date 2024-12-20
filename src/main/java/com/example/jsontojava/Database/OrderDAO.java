package com.example.jsontojava.Database;

import com.example.jsontojava.order.OrderDetails;
import com.example.jsontojava.customer.Customer;
import com.example.jsontojava.customer.ShippingAddress;

import java.sql.*;

public class OrderDAO {

    // Insert an order into the database
    public void insertOrder(OrderDetails orderDetails) throws SQLException {
        String insertOrderSQL = "INSERT INTO orders (customer_name, customer_email, customer_phone, street, city, zipCode, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertOrderSQL)) {
            pstmt.setString(1, orderDetails.getCustomer().getName());
            pstmt.setString(2, orderDetails.getCustomer().getEmail());
            pstmt.setString(3, orderDetails.getCustomer().getPhone());
            pstmt.setString(4, orderDetails.getShippingAddress().getStreet());
            pstmt.setString(5, orderDetails.getShippingAddress().getCity());
            pstmt.setString(6, orderDetails.getShippingAddress().getZipCode());
            pstmt.setString(7, orderDetails.getShippingAddress().getCountry());

            pstmt.executeUpdate();
        }
    }

    // Read an order by customer name
    public OrderDetails getOrderByCustomerName(String customerName) throws SQLException {
        String query = "SELECT * FROM orders WHERE customer_name = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, customerName);
            ResultSet rs = pstmt.executeQuery();

        }
        return null;
    }



}
