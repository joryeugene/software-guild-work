package com.jorypestorious.unitoneskillcheck;

public class Adder {
    
    public static void main(String[] args) {  
        System.out.println("1 + 1 = " + add(1,1));
        System.out.println("2 + 3 = " + add(2,3));
        System.out.println("5 + 8 = " + add(5,8));
        System.out.println("95 + 42 = " + add(95,42));
    }
    
    static int add(int a, int b) {
        return a + b;
    }

}