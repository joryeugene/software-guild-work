package com.jorypestorious.junitdrills.conditionals;

public class Max {
//Given three int values, a b c, return the largest. 
//
//max(1, 2, 3) -> 3
//max(1, 3, 2) -> 3
//max(3, 2, 1) -> 3

    public int max(int a, int b, int c) {
        int max = (a>b) ? a : b;
        return (max>c) ? max : c;
    }

}
