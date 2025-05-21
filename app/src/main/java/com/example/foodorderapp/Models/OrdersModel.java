package com.example.foodorderapp.Models;

public class OrdersModel {

    int orderImage;
    String SoldItemName , Price, OrderNumber;

    public OrdersModel(int orderImage, String soldItemName, String price, String orderNumber) {
        this.orderImage = orderImage;
        SoldItemName = soldItemName;
        Price = price;
        OrderNumber = orderNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return SoldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        SoldItemName = soldItemName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }
}
