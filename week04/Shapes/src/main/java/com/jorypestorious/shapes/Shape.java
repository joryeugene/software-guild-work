package com.jorypestorious.shapes;

public abstract class Shape {
    
    protected String color;
    
    protected Shape() {
        color = "White";
    }
    
    protected Shape(String color) {
        this.color = color;
    }
    
    public abstract double area();
    
    public abstract double perimeter();

}
