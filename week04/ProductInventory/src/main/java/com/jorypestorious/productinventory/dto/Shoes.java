package com.jorypestorious.productinventory.dto;

public class Shoes extends Product {
    
    private String size;
    private String color;
    
    public Shoes(String brand, String name, String size, String color, double price, int quantity) {
        super();
        this.id = super.getProductId();
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Shoes(int id, String brand, String name, String size, String color, double price, int quantity) {
        super();
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String toString() {
        return id + " " + brand + " - " + name + " " + size + " " + color + " (" + df.format(price) + " : " + quantity + ")"; 
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
