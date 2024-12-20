package com.example.jsontojava.shared;

import com.example.jsontojava.Database.OrderDAO;
import com.example.jsontojava.order.Order;
import com.example.jsontojava.order.OrderDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderProcessService {

    private static final Logger log = LogManager.getLogger(OrderProcessService.class);
    private final OrderDAO orderDAO = new OrderDAO();

    public void process() {
        log.trace("Starting process method");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderWrapper orderWrapper = objectMapper.readValue(
                    this.getClass().getClassLoader().getResourceAsStream("Data.json"),
                    OrderWrapper.class
            );

            if (orderWrapper == null || orderWrapper.getOrders() == null) {
                log.warn("OrderWrapper or Orders list is null");
                return;
            }

            List<Order> orders = orderWrapper.getOrders();
            for (Order order : orders) {
                OrderDetails orderDetails = order.getOrder();
                log.info("Processing order for customer: {}", orderDetails.getCustomer().getName());

                // Perform CRUD operations
                orderDAO.insertOrder(orderDetails);
                log.info("Order inserted successfully");

                OrderDetails retrievedOrder = orderDAO.getOrderByCustomerName(orderDetails.getCustomer().getName());
                log.info("Order retrieved: " + retrievedOrder);

            }

        } catch (Exception e) {
            log.error("Error processing orders", e);
        }
    }
}
