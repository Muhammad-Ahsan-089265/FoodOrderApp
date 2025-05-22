package com.example.foodorderapp.Models;

/**
 * Model class representing a main food item.
 */
public class MainModel {
    private int image;           // Drawable resource ID for the food image
    private String name;         // Name of the food item
    private String price;        // Price as a string (e.g., "4.99")
    private String description;  // Description of the food item

    public MainModel(int image, String name, String price, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
