package com.jorypestorious.refactorintoobjects;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public void run() {

        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        
        System.out.print("How many dollars do you have? ");
        int bet = scan.nextInt(),
            initialBet = bet,
            max = bet,
            rollsAtMax = 0,
            totalRolls = 0;
        
        while (bet > 0) {
            totalRolls++;
            if (1 + r.nextInt(6) == 1 + r.nextInt(6)) {
                bet +=  4;
                if (max < bet) {
                    max = bet;
                    rollsAtMax = totalRolls;
                }
                
            } else {
                bet--;
            }
        }
        
        String rollsAtMaxMsg;
        if (initialBet == max) {
            rollsAtMaxMsg = "at the beginning";
        } else {
            rollsAtMaxMsg = "after " + rollsAtMax + " rolls";
        }
        
        System.out.println("\nYou are broke after " + totalRolls + " rolls.\n");
        System.out.println("You should have quit " + rollsAtMaxMsg + " when you had $" + max + ".");
    }
}
