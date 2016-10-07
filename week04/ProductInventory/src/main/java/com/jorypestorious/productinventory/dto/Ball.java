package com.jorypestorious.productinventory.dto;

public class Ball extends Product {
    
    private String dots;
    
    public Ball(String brand, String name, String dots, double price, int quantity) {
        this.id = super.getProductId();
        this.brand = brand;
        this.name = name;
        this.dots = dots;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Ball(int id, String brand, String name, String dots, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.dots = dots;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "[ID: " + getDisplayId() + "] " + getCategory() + ":    " + brand + " - " + name + " - " + dots + " (" + df.format(price) + " : " + quantity + ")"; 
    }
    
    @Override
    public String getCategory() {
        return "Ball";
    }

    public String getDots() {
        return dots;
    }

    public void setDots(String dots) {
        this.dots = dots;
    }
    
}
