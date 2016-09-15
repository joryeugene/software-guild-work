package com.jorypestorious.pbd.forloops;

import java.util.Random;

public class BabyBlackjack {
    
    static int random1to10() {
        Random r = new Random();
        return 1 + r.nextInt(10);
    }
    
    public static void main(String[] args) {
        int player1 = random1to10(),
            player2 = random1to10(),
            dealer1 = random1to10(),
            dealer2 = random1to10(),
            playerSum = player1 + player2,
            dealerSum = dealer1 + dealer2;
        
        System.out.println("Baby Blackjack!");
        System.out.println("\nYou drew " + player1 + " and " + player2);
        System.out.println("Your total is " + playerSum);
        System.out.println("\nThe dealer has " + dealer1 + " and " + dealer2);
        System.out.println("The dealer's total is " + dealerSum + "\n");
        
        if (dealerSum == playerSum) {
            System.out.println("DRAW!");
        } else if (dealerSum < playerSum) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }
        
    }
}