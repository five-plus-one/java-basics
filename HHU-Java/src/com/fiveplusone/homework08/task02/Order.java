package com.fiveplusone.homework08.task02;

public class Order {
    private String orderId;
    private String customerName;
    private String drinkName;

    public Order(String orderId, String customerName, String drinkName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.drinkName = drinkName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    @Override
    public String toString() {
        return orderId + " " + customerName + " " + drinkName;
    }
}