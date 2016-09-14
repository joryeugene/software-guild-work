package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class TheWorstNumberGuessingGameEver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int secretNum = 4;
        
        System.out.println("TEH WORST NUBMER GESSING GAME EVAR!!!!!!!1!");
        System.out.print("I\"M THKING OF A NBR FROM 1-10.  TRY 2 GESS! ");
        int guess = scan.nextInt();
        
        if (guess == secretNum) {
            System.out.println("LOL!!! U GOT IT!  I CANT BELEIVE U GESSED IT WAS " + secretNum + "!");
        } else {
            System.out.println("W00T!  U SUX0R!!!  I PWN J00!!!  IT WAS " + secretNum + "!");
        }
    }
}
