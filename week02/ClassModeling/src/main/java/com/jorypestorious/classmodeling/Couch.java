package com.jorypestorious.classmodeling;

public class Couch {
    
    private String fabric;
    private int numOfSeats;
    private double weightCapacity;
    
    Couch() {
        this.numOfSeats = 3;
        this.fabric = "leather";
    }
    
    Couch(String fabric) {
        this.numOfSeats = 3;
        this.fabric = fabric;
    }
    
    Couch(String fabric, int numOfSeats) {
        this.numOfSeats = numOfSeats;
        this.fabric = fabric;
    }
    
    public void setWeightCapacity(double weight) {
        this.weightCapacity = weight;
    }
    
    public double getWeightCapacity() {
        return weightCapacity;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

}
