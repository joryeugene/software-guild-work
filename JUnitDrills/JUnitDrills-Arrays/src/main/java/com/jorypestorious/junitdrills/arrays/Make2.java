package com.jorypestorious.junitdrills.arrays;

public class Make2 {
//    Given 2 int arrays, a and b, return a new array length 2 containing,
    //as much as will fit, the elements from a followed by the elements from b.
    //The arrays may be any length, including 0, but there will be 2 or more elements available between the 2 arrays. 
//
//    make2({4, 5}, {1, 2, 3}) -> {4, 5}
//    make2({4}, {1, 2, 3}) -> {4, 1}
//    make2({}, {1, 2}) -> {1, 2}

    public int[] make2(int[] a, int[] b) {
        
        int[] result = new int[2];
        
        int firstLoopLimit = (a.length >= 2) ? 2 : a.length;
        
        for (int i = 0; i < firstLoopLimit; i++) {
            result[i] = a[i];
        }
        
        for (int i = firstLoopLimit; i < 2 ; i++) {
            result[i] = b[i-firstLoopLimit];
        }
        
        return result;

    }

}
