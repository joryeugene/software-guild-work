package com.jorypestorious.vendingmachine.dto;

import java.text.DecimalFormat;

public class Item {
    
    private final DecimalFormat df;
    private String name;
    private double cost;
    private int count;
    
    public Item(String name, double cost, int count) {
        df = new DecimalFormat("0.00");
        this.name = name;
        this.cost = cost;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return name + " - $" + df.format(cost) + " - Quantity: " + count;
                
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }
    
    
}
