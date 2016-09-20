package com.jorypestorious.classmodeling;

class House {
    
    private int yearBuilt;
    private int numOfRooms;
    private int numOfFloors;
    private String color;
    
    public House (int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    public House () {
        this.yearBuilt = 1900;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }    

}
