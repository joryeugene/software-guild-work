package com.jorypestorious.productinventory.dto;

public class Ball extends Product {
    
    public Ball(String brand, String name, double price, int quantity) {
        super();
        this.id = super.getProductId();
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Ball(int id, String brand, String name, double price, int quantity) {
        super();
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}
