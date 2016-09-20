package com.jorypestorious.classmodeling;

public class Square {
    
    private final int sideLength;
    
    Square() {
        this.sideLength = 5;
    }
    
    Square(int sideLength) {
        this.sideLength = sideLength;
    }
    
    public int getSideLength() {
        return sideLength;
    }
    
    public int getPerimeter() {
        return sideLength * 4;
    }
    
    public int getArea() {
        return sideLength * sideLength;
    }

}
