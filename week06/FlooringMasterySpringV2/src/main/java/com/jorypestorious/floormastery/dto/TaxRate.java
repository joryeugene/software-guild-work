package com.jorypestorious.floormastery.dto;

public class TaxRate {
    
    private final String stateCode;
    private final double taxRate;

    public TaxRate(String stateCode, double taxRate) {
        this.stateCode = stateCode;
        this.taxRate = taxRate / 100;
    }

    public String getStateCode() {
        return stateCode;
    }

    public double getTaxRate() {
        return taxRate;
    }
    
}
