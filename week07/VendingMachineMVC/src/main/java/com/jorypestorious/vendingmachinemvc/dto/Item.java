package com.jorypestorious.vendingmachinemvc.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Item {
    
    private int id;
    @NotEmpty(message="You must supply a value for Item Name.")
    @Length(max=50, message="Item Name must be no more than 50 characters in length.")
    private String name;
    @DecimalMin(value = "0.01", message="Cost must be atleast 0.01")
    private double cost;
    @Min(value = 0, message="Quantity must not be less than 0")
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
