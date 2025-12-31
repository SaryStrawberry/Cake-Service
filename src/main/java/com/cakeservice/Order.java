package com.cakeservice;

import java.time.LocalDate;
public class Order {
    public Cake cake;
    public LocalDate orderCreationDate;
    public LocalDate orderDeliveryDate;
    public String deliveryLocation;
    public String message;
    public double finalCost;

    //Main constructor method
    public Order(Cake cake, LocalDate orderDeliveryDate, String deliveryLocation, String message, double finalCost) {
        this.cake = cake;
        orderCreationDate = LocalDate.now();
        this.orderDeliveryDate = orderDeliveryDate;
        this.deliveryLocation = deliveryLocation;
        this.message = message;
        this.finalCost = finalCost;
    }

    //Constructor method that does not require a message
    public Order(Cake cake, LocalDate orderDeliveryDate, String deliveryLocation, double finalCost) {
        this.cake = cake;
        orderCreationDate = LocalDate.now();
        this.orderDeliveryDate = orderDeliveryDate;
        this.deliveryLocation = deliveryLocation;
        this.finalCost = finalCost;
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
