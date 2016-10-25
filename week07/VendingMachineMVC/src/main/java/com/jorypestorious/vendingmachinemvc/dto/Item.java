package com.jorypestorious.vendingmachinemvc.dto;

public class Item {
    
    private int id;
    private String name;
    private double cost;
    private int count;
    
    public Item() {}

    public Item(String name, double cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }
    
    public int takeOne() {
        return --count;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
