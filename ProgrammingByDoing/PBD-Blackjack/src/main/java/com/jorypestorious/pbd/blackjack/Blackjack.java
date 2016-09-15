package com.jorypestorious.pbd.blackjack;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("BLACKJACK (Simplified)\n");
        
        int userC1 = dealCard(),
            userC2 = dealCard(),
            dealerC1 = dealCard(),
            dealerC2 = dealCard(),
            userSum = userC1 + userC2,
            dealerSum = dealerC1 + dealerC2;
        
        System.out.println("You get " + userC1 + " and " + userC2);
        System.out.println("Your total is " + userSum);
        
        System.out.println("\nThe dealer has " + dealerC1 + " showing, and a hidden card");
        
        while (userSum < 21) {
            System.out.print("\nWould you like to 'hit' or 'stay'? ");
            String hitOrStay = scan.next();
            if (hitOrStay.equals("stay")) break;
            else {
                int newCard = dealCard();
                userSum += newCard;
                System.out.println("\nYou drew " + newCard + " and your total is now " + userSum);
            }
        }
        
        if (userSum > 21) {
                System.out.println("\nYOU BUSTED! SORRY!");
                System.exit(0);
        }
        
        if (userSum == 21) {
                System.out.println("\nBLACKJACK! Well Played.");
                System.exit(0);
        }
        
        System.out.println("\nOk, dealer's turn.");
        System.out.println("His hidden card was " + dealerC2);
        System.out.println("His total is " + dealerSum + "\n");
        
        while (dealerSum < 17) {
            System.out.println("Dealer chooses to hit.");
            int newCard = dealCard();
            dealerSum += newCard;
            System.out.println("He draws " + newCard + " and his total is now " + dealerSum + "\n");
        }
        
        if (dealerSum < 21) System.out.println("The dealer stays.");
        
        if (dealerSum == 21) {
            System.out.println("Dealer got BLACKJACK! You lose~");
            System.exit(0);
        }
        
        if (dealerSum > 21) {
            System.out.println("The dealer BUSTS! You WIN!");
            System.exit(0);
        }
        
        if (dealerSum < userSum) {
            System.out.println("\nYour " + userSum + " beats the dealer's " + dealerSum + ". Well played. You win!");
        } else {
            if (dealerSum == userSum) System.out.println("Dealer wins all ties.");
            System.out.println("\nThe dealer's " + dealerSum + " beats your " + userSum + ". Sorry, you lose.");
        }
    }
    
    static int dealCard() {
        Random r = new Random();
        return 2 + r.nextInt(10);
    }
}