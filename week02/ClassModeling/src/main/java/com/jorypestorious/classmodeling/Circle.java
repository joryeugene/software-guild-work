package com.jorypestorious.classmodeling;

public class Circle {
    
    private final double radius;
    
    Circle() {
        this.radius = 5;
    }
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
    public double getArea() {
        return radius * radius * Math.PI;
    }

}
