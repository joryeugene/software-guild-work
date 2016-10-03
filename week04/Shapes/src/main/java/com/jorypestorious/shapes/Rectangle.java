package com.jorypestorious.shapes;

public class Rectangle extends Shape {
    
    private double height;
    private double width;

    public Rectangle() {
        super();
    }

    public Rectangle(String color) {
        super(color);
    }
    
    public Rectangle(double height, double width) {
        this();
        this.height = height;
        this.width = width;
    }
    
    public Rectangle(String color, double height, double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public double perimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public double area() {
        return height * width;
    }

}
