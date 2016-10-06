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
    
    public Product() {}
    
    public Product(String brand, String name, double price, int quantity) {
        this.id = getProductId();
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(int id, String brand, String name, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    protected final int getProductId() {
        int id = productId;
        productId++;
        return id;
    }
    
    public final static int getCurrentProductId() {
        return productId-1;
    }
    
    public final static void setProductId(int id) {
        if (!productIdSet) {
            productIdSet = true;
            productId = id;            
        }
    }
    
    public String getCategory() {
        return "Product";
    }
    
    @Override
    public String toString() {
        return "[ID: " + id + "] " + brand + " - " + name + " (" + df.format(price) + " : " + quantity + ")"; 
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
    
    public String getPriceFormatted() {
        return df.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
}
