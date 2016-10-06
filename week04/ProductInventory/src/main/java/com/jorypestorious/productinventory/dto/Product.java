package com.jorypestorious.productinventory.dto;

import java.text.DecimalFormat;

public class Product {
    
    protected static DecimalFormat df = new DecimalFormat("$###,##0.00");
    private static int productId = 1;
    private static boolean productIdSet = false;
    
    protected int id;
    
    protected String brand;
    protected String name;
    protected double price;
    protected int quantity;
    
    public Product() {
        id = productId;
        productId++;
    }
    
    public Product(String brand, String name, double price, int quantity) {
        this();
        this.id = productId;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(int id, String brand, String name, double price, int quantity) {
        this();
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public final static int getProductId() {
        return productId;
    }
    
    public final static void setProductId(int id) {
        if (!productIdSet) {
            productIdSet = true;
            productId = id;            
        }
    }
    
    public String toString() {
        return id + " " + brand + " - " + name + " (" + df.format(price) + " : " + quantity + ")"; 
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
