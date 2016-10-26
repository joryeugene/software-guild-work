package com.jorypestorious.vendingmachinemvc.dto;

import javax.validation.constraints.DecimalMin;

public class Money {
    
    @DecimalMin(value = "0.01", message="Must enter atleast 0.01")
    private double amount = 0.0;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void addAmount(double amount) {
        this.amount += amount;
    }
    
    public void removeAmount(double amount) {
        this.amount -= amount;
    }

}
