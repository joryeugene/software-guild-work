package com.jorypestorious.pbd.arrays;

import java.util.Random;

public class FindingTheLargestValueInAnArray {
    
    public static void main(String[] args) {
        Random r = new Random();
        
        System.out.print("Array: ");
        int[] array = new int[10];
        int max = 0;
        
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + r.nextInt(100);
            System.out.print(array[i] + " ");
            if (array[i] > max) max = array[i];
        }
        
        System.out.println("\n\nThe largest value is " + max);
        
    }

}