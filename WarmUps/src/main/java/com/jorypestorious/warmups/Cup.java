package com.jorypestorious.warmups;

public class Cup {
    
    private String color;
    private String material;
    private final String type;
    private final double containerVol;
    private double currentLiquidVol = 0.0;
    
    Cup() {
        this.type = "coffee cup";
        this.containerVol = 10.0;
    }
    
    Cup(String type, double containerVol) {
        this.type = type;
        this.containerVol = containerVol;
    }
    
    public void fill(double addedVol) {
        if (addedVol + currentLiquidVol > containerVol) {
            this.currentLiquidVol = this.containerVol;
        } else {
            this.currentLiquidVol += addedVol;
        }
    }
    
    public void drink(double subtractedVol) {
        if (subtractedVol > currentLiquidVol) {
            this.currentLiquidVol = 0.0;
        } else {
            this.currentLiquidVol -= subtractedVol;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public double getContainerVol() {
        return containerVol;
    }

}
