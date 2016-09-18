package com.jorypestorious.unitoneskillcheck;

public class Counter {
    
    public static void main(String[] args) {
        
        Counter obj = new Counter();
        
        obj.toTen();
        System.out.println(""); // line break
        
        obj.toN(3);
        System.out.println(""); // line break
        
        obj.toN(8);
        System.out.println(""); // line break
        
        obj.toN(200);
        System.out.println(""); // line break
        
    }
    
    void toTen() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
    
    void toN(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }
    }

}