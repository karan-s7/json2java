package com.example.jsontojava.order;

import lombok.Data;

@Data
public class InventoryItem {
    private String itemName;
    private int quantity;
    private double totalPrice;
}
