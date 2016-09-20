package com.jorypestorious.classmodeling;

public class Truck {
    
    private String make;
    private String model;
    private int year;
    
    Truck(String make, String model) {
        this.make = make;
        this.model = model;
    }
    
    public void drive() {
        // drive
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
