package com.jorypestorious.warmups;

import java.util.Scanner;

public class Sept20 {

//Let's try this:
//
//Create a String[] of some pre-determined size.
//In a loop, allow your user to enter a position and a string value. The position should be 1-based -- that is, the item at index 0(zero) is identified as "1",
//Using the position, set the array value at that position to the user-entered value.
//If the user types "quit", display the contents of our String "database" and exit.
//If you get done, be sure to verify that all input is valid (position is an integer greater than 0 and less than or equal to the size of the array).
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How big of an array would you like? ");
        int size = scan.nextInt();
        
        String[] myStrArr = new String[size];
        
        boolean keepRunning = true;
        int position;
        String strInput;
        
        
        System.out.println("\nString array from 1 to " + myStrArr.length + ".");
        System.out.println("Enter a position in the array and then a String value to fill in the array.");
        System.out.println("Enter 'quit' as the String value to see the values you've input into the array.\n");
        
        do {      
            System.out.print("Position: ");
            position = scan.nextInt() - 1;
            while (position < 0 || position > myStrArr.length - 1) {
                System.out.print("Choose a number between 1 and " + myStrArr.length + ": ");
                position = scan.nextInt() - 1;
            }
            
            scan.nextLine(); // clear
            System.out.print("String value: ");
            strInput = scan.nextLine();
            
            if (strInput.equals("quit")) {
                keepRunning = false;
            } else {
                myStrArr[position] = strInput;
            }
            
            System.out.println(""); // line break
            
        } while (keepRunning);
        
        System.out.println("");
        
        for (int i = 0; i < myStrArr.length; i++) {
            System.out.println((i + 1) + ". " + myStrArr[i]);
        }
    }
}
