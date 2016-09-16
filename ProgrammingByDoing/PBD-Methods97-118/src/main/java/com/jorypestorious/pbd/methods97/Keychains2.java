package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class Keychains2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ye Olde Keychain Shoppe");
        boolean keepRunning = true;
        
        int numOfKeychains = 0,
                priceOfKeychains = 10;
        
        while (keepRunning) {
            System.out.println("\n1. Add Keychains to Order\n"
                    + "2. Remove Keychains from Order\n"
                    + "3. View Current Order\n"
                    + "4. Checkout\n");
            
            System.out.print("Please enter your choice: ");
            int choice = scan.nextInt();
            System.out.println(""); // line break
            
            switch (choice) {
                case 1:
                    numOfKeychains = add_keychains(numOfKeychains);
                    break;
                case 2:
                    numOfKeychains = remove_keychains(numOfKeychains);
                    break;
                case 3:
                    view_order(numOfKeychains, priceOfKeychains);
                    break;
                case 4:
                    checkout(numOfKeychains, priceOfKeychains);
                    keepRunning = false;
                    break;
                default:
                    keepRunning = false;
            }
        }
    }
    
    public static int scan() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    
    public static int add_keychains(int numOfKeychains) {
        System.out.print("You have " + numOfKeychains + " keychains. How many to add? ");
        numOfKeychains += scan();
        System.out.println("You now have " + numOfKeychains + " keychains.");
        return numOfKeychains;
    }
    
    public static int remove_keychains(int numOfKeychains) {
        System.out.print("You have " + numOfKeychains + " keychains. How many to remove? ");
        numOfKeychains -= scan();
        System.out.println("You now have " + numOfKeychains + " keychains.");
        return numOfKeychains;
    }
    
    public static void view_order(int numOfKeychains, int priceOfKeychains) {
        System.out.println("You have " + numOfKeychains + " keychains.");
        System.out.println("Keychains cost $" + priceOfKeychains + " each.");
        System.out.println("Total cost is $" + (numOfKeychains * priceOfKeychains) + ".");
        
    }
    
    public static void checkout(int numOfKeychains, int priceOfKeychains) {
        System.out.print("What is your name? ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        view_order(numOfKeychains, priceOfKeychains);
        System.out.println("Thanks for your order, " + name + "!");
    }
}