package com.jorypestorious.junitdrills.conditionals;

public class Between10and20 {
//Given 2 int values, return true if either of them is in the range 10..20 inclusive. 
//
//between10and20(12, 99) -> true
//between10and20(21, 12) -> true
//between10and20(8, 99) -> false

    public boolean between10and20(int a, int b) {
        return a>=10&&a<=20 || b>=10&&b<=20;
    }

}
