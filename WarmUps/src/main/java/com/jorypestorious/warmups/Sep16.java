package com.jorypestorious.warmups;

import java.util.Scanner;

public class Sep16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give me two numbers!");
        System.out.print("First number: ");
        int firstNum = scan.nextInt();
        System.out.print("Second number: ");
        int secondNum = scan.nextInt();
        
        int lowerNum = ( firstNum < secondNum ) ? firstNum : secondNum;
        int higherNum = ( firstNum > secondNum ) ? firstNum : secondNum;
        
        int sum = 0;
        
        for (int i = lowerNum; i <= higherNum; i++) {
            sum += i;
        }
        
        System.out.println("\nThe sum of numbers from " + lowerNum + " to " + higherNum + " is: " + sum);
    }
}
