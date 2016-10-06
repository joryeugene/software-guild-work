package com.jorypestorious.productinventory.dto;

public class Racquet extends Product {
    
    private String weight;
    private String color;
    
    public Racquet(String brand, String name, String weight, String color, double price, int quantity) {
        super();
        this.id = super.getProductId();
        this.brand = brand;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Racquet(int id, String brand, String name, String weight, String color, double price, int quantity) {
        super();
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String toString() {
        return id + " " + brand + " - " + name + " " + weight + " " + color + " (" + df.format(price) + " : " + quantity + ")"; 
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
