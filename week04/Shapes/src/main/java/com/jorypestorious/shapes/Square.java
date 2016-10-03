package com.jorypestorious.shapes;

public class Square extends Shape {
    
    private double side;
    
    public Square() {
        super();
    }
    
    public Square(String color) {
        super(color);
    }
    
    public Square(double side) {
        this();
        this.side = side;
    }
    
    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
    
    @Override
    public double perimeter() {
        return side * 4;
    }

}
