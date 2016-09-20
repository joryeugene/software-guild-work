package com.jorypestorious.classmodeling;

public class Car {
    
    private String make;
    private String model;
    private int year;
    
    Car(String make, String model) {
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
