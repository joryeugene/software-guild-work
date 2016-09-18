package com.jorypestorious.pbd.arrays;

import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArray {
    
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
        boolean present = false;
        
        System.out.println(""); // line break
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numToFind) present = true;
        }
        
        if (present) System.out.println(numToFind + " is in the array.");
        else System.out.println(numToFind + " is NOT in the array.");
    }

}