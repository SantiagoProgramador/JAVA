package com.riwi.S;

import java.util.List;

public class Order {
    private List<String> items;
    private double totalAmount;

    public Order(List<String> items) {
        this.items = items;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        // LOGIC TO CALCULATE THE TOTAL OF THE ORDER
        return 100.0; // simplificado
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
