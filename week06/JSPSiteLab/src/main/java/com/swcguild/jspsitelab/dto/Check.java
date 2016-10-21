package com.swcguild.jspsitelab.dto;

public class Check {
    
    private final double subtotal;
    private final double tipPercentage;
    private double tip;
    
    public Check(double subtotal, double tipPercentage) {
        this.subtotal = subtotal;
        this.tipPercentage = tipPercentage;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTipPercentage() {
        return tipPercentage;
    }
    
    public double getTip() {
        tip = subtotal * (tipPercentage/100);
        return tip;
    }

    public double getTotal() {
        return subtotal + getTip();
    }

}