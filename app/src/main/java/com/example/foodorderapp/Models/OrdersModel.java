package com.example.foodorderapp.Models;

public class OrdersModel {

    private int orderImage;
    private String soldItemName;
    private int price;          // Price stored as integer (e.g., cents)
    private int orderNumber;    // Order ID or number
    private int quantity;       // Quantity ordered
    private String description; // Description of the order/food item

    // Full constructor with quantity and description
    public OrdersModel(int orderImage, String soldItemName, int price, int orderNumber, int quantity, String description) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.description = description;
    }

    // Empty constructor
    public OrdersModel() {
    }

    // Getters and setters
    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Format price as string with 2 decimals
    public String getFormattedPrice() {
        return String.format("%.2f", price / 100.0);
    }

    @Override
    public String toString() {
        return "OrdersModel{" +
                "orderImage=" + orderImage +
                ", soldItemName='" + soldItemName + '\'' +
                ", price=" + price +
                ", orderNumber=" + orderNumber +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
