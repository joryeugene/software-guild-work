package com.jorypestorious.junitdrills.conditionals;

public class Diff21 {
//Given an int n, return the absolute value of the difference between n and 21, 
    //except return double the absolute value of the difference if n is over 21. 
//
//diff21(23) -> 4
//diff21(10) -> 11
//diff21(21) -> 0

    public int diff21(int n) {
        int result = Math.abs(21-n);
        if (n>21) return result*2;
        return result;
    }

}
