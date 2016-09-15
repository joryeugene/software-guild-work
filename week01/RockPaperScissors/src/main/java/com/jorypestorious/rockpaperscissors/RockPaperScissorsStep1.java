package com.jorypestorious.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsStep1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        int randomNum = 1 + r.nextInt(3);
        
        System.out.print("Rock (1), Paper (2), or Scissors (3)? ");
        int choice = scan.nextInt();
        
        if (randomNum == choice) {
            System.out.println("TIE!");
        } else if (choice == 1 && randomNum == 3 || choice == 2 && randomNum == 1 || choice == 3 && randomNum == 2) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("COMPUTER WINS!");
        }
    }
}
