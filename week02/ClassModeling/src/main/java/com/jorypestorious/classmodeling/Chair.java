package com.jorypestorious.classmodeling;

public class Chair {
    
    private String material;
    private int numOfLegs;
    private double weightCapacity;
    
    Chair() {
        this.numOfLegs = 4;
        this.material = "wood";
    }
    
    Chair(String material) {
        this.numOfLegs = 4;
        this.material = material;
    }
    
    Chair(String material, int numOfLegs) {
        this.numOfLegs = numOfLegs;
        this.material = material;
    }
    
    public void setWeightCapacity(double weight) {
        this.weightCapacity = weight;
    }
    
    public double getWeightCapacity() {
        return weightCapacity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

}
