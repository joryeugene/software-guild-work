package com.jorypestorious.classmodeling;

public class Airplane {
    
    private String model;
    private int topSpeed;
    private int size;
    
    Airplane(String model) {
        this.model = model;
    }
    
    public void fly() {
        // fly
    }
    
    public void land() {
        // land
    }
    
    public void takeoff() {
        // takeoff
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}
