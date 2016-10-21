package com.swcguild.jspsitelab.dto;

public class FlooringReport {
    
    private final int width;
    private final int length;
    private final double materialCost;
    private final double laborCost;

    public FlooringReport(int width, int length, double materialCost, double laborCost) {
        this.width = width;
        this.length = length;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
    
    public int getArea() {
        return width * length;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }
    
}
