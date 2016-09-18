package com.jorypestorious.pbd.arrays;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimes {
    
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        
        int[] array = new int[10];
        System.out.print("Array: ");
        
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + r.nextInt(50);
            System.out.print(array[i] + " ");
        }
        
        System.out.print("\nValue to find: ");
        int numToFind = scan.nextInt();
        int count = 0;
        String times = " times.";
        
        System.out.println(""); // line break
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numToFind) count++;
        }
        
        if (count == 1) times = " time.";
        
        System.out.println(numToFind + " was found " + count + times);
    }

}