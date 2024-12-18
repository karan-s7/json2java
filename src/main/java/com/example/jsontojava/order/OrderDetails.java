package com.example.jsontojava.order;

import com.example.jsontojava.customer.Customer;
import com.example.jsontojava.customer.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private Customer customer;
    private ShippingAddress shippingAddress;
    private List<InventoryItem> inventory;
}
