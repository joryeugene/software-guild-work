package com.jorypestorious.productinventory.dto;

public class Shoe extends Product {
    
    private String size;
    private String color;
    
    public Shoe(String brand, String name, String size, String color, double price, int quantity) {
        this.id = super.getProductId();
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Shoe(int id, String brand, String name, String size, String color, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "[ID: " + id + "] " + brand + " - " + name + " - " + size + " - " + color + " (" + df.format(price) + " : " + quantity + ")"; 
    }
    
    @Override
    public String getCategory() {
        return "Shoe";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
