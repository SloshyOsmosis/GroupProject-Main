package com.example.myapplication;

public class OrderHistoryModel {
    String orderStatus;
    String deliveryDate;

    int img;

    public OrderHistoryModel(String orderStatus, String deliveryDate, int img) {
        this.orderStatus = orderStatus;
        this.deliveryDate = deliveryDate;
        this.img = img;

    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public int getImg() {
        return img;
    }
}
