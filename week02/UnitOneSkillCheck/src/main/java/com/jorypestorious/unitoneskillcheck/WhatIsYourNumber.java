package com.jorypestorious.unitoneskillcheck;

import java.util.Scanner;

public class WhatIsYourNumber {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose an integer: ");
        int userNum = scan.nextInt();
        
        System.out.println("\nYour number is: " + userNum + "\n");
        
        if (userNum > 0) {
            for (int i = 0; i <= userNum; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = 0; i >= userNum; i--) {
                System.out.println(i);
            }
        }
        
        System.out.println("\nThank you for playing");
        
    }
    
}