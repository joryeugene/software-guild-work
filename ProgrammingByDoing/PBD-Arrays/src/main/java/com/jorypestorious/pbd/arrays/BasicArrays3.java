package com.jorypestorious.pbd.arrays;

import java.util.Random;

public class BasicArrays3 {
    
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random r = new Random();
        
        // i not zero but 1 so I can do the modulus for constant line breaks
        for (int i = 1; i < array.length+1; i++) {
            array[i-1] = 10 + r.nextInt(90);
            System.out.print(array[i-1] + "  ");
            if (i % 20 == 0) System.out.println("");
        }
    }
    
}
