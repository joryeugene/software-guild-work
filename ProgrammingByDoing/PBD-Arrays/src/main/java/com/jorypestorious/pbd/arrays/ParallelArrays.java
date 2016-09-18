package com.jorypestorious.pbd.arrays;

import java.util.Scanner;

public class ParallelArrays {
    
    public static void main(String[] args) {
        String[] lastNames = {"Mitchell", "Ortiz", "Luu", "Zimmerman", "Brooks"};
        double[] gradeAverages = {99.5, 78.5, 95.6, 96.8, 82.7};
        int[] studentIds = {123456, 813225, 823669, 307760, 827131};
        
        System.out.println("Values:");
        
        for (int i = 0; i < lastNames.length; i++) {
            System.out.println("\t" + lastNames[i] + " " + gradeAverages[i] + " " + studentIds[i]);
        }
        
        System.out.print("\nID number to find: ");
        Scanner scan = new Scanner(System.in);
        int idNum = scan.nextInt();
        
        System.out.println(""); // line break
        
        boolean found = false;
        
        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i] == idNum) {
                found = true;
                System.out.println("Found in slot " + i +
                        "\n\tName: " + lastNames[i] +
                        "\n\tAverage: " + gradeAverages[i] +
                        "\n\tID: " + studentIds[i]);
            }
        }
        
        if (!found) System.out.println("Could not find student with that ID");
        
    }

}