package com.example.jsontojava.shared;

import com.example.jsontojava.order.Order;
import lombok.Data;
import java.util.List;

@Data
public class OrderWrapper {
    private List<Order> orders;
}
