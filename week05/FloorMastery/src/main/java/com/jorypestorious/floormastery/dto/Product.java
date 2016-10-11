package com.jorypestorious.floormastery.dto;

public class Product {
    
    private final String type;
    private final double materialCostPerSquareFoot;
    private final double laborCostPerSquareFoot;

    public Product(String type, double materialCostPerSquareFoot, double laborCostPerSquareFoot) {
        this.type = type;
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public String getType() {
        return type;
    }

    public double getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }
    
    

}
