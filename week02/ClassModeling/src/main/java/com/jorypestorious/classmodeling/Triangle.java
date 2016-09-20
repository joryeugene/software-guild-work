package com.jorypestorious.classmodeling;

public class Triangle {
    
    private final int side1;
    private final int side2;
    private final int side3;
    
    Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public int getPerimeter() {
        return side1 + side2 + side3;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

}
