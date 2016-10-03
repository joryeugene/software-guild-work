package com.jorypestorious.shapes;

public class Circle extends Shape {
    
    private double radius;
    
    public Circle() {
        super();
    }

    public Circle(String color) {
        super(color);
    }
    
    public Circle(double radius) {
        this();
        this.radius = radius;
    }
    
    public Circle(String color, double radius) {
        this(color);
        this.radius = radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

}
