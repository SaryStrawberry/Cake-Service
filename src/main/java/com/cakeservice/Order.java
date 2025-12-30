package com.cakeservice;

import java.time.LocalDate;

public class Order {
    public Cake cake;
    public LocalDate orderCreationDate;
    public LocalDate orderDeliveryDate;
    public String deliveryLocation;
    public String message;
    public double finalCost;

    public Order(Cake cake, LocalDate orderDeliveryDate, String deliveryLocation, String message, double finalCost) {
        cake = this.cake;
        orderCreationDate = LocalDate.now();
        orderDeliveryDate = this.orderDeliveryDate;
        deliveryLocation = this.deliveryLocation;
        message = this.message;
        finalCost = this.finalCost;
    }

    public Cake getCake() {
        return cake;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }

    public LocalDate orderDeliveryDate() {
        return orderDeliveryDate;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public String getMessage() {
        return message;
    }

    public double getFinalCost() {
        return finalCost;
    }
}
