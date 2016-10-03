package com.jorypestorious.shapes;

public class RightTriangle extends Shape {
    
    private double shortSide1;
    private double shortSide2;
    
    public RightTriangle() {
        super();
    }

    public RightTriangle(String color) {
        super(color);
    }
    
    public RightTriangle(double shortSide1, double shortSide2) {
        this();
        this.shortSide1 = shortSide1;
        this.shortSide2 = shortSide2;
    }
    
    public RightTriangle(String color, double shortSide1, double shortSide2) {
        super(color);
        this.shortSide1 = shortSide1;
        this.shortSide2 = shortSide2;
    }

    @Override
    public double perimeter() {
        return shortSide1 + shortSide2 + Math.sqrt(shortSide1*2 + shortSide2*2);
    }

    @Override
    public double area() {
        return (shortSide1 * shortSide2) / 2;
    }
}
