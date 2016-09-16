package com.jorypestorious.pbd.methods97;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Keychains3 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ye Olde Keychain Shoppe");
        boolean keepRunning = true;
        
        int numOfKeychains = 0,
            priceOfKeychains = 10,
            base_shipping = 5,
            per_keychain_shipping = 1;
        double tax = 8.25;
        
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
                    view_order(numOfKeychains, priceOfKeychains, tax, base_shipping, per_keychain_shipping);
                    break;
                case 4:
                    checkout(numOfKeychains, priceOfKeychains, tax, base_shipping, per_keychain_shipping);
                    keepRunning = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }
    
    public static int scan() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    
    public static int add_keychains(int numOfKeychains) {
        youHave(numOfKeychains);
        System.out.print("How many to add? ");
        numOfKeychains += scan();
        youHave(numOfKeychains);
        return numOfKeychains;
    }
    
    public static int remove_keychains(int numOfKeychains) {
        youHave(numOfKeychains);
        System.out.print("How many to remove? ");
        int input = scan();
        if (numOfKeychains - input < 0) {
            System.out.print("You can't have less than zero. Please enter a different number: ");
            input = scan();
        }
        numOfKeychains -= input;
        youHave(numOfKeychains);
        return numOfKeychains;
    }
    
    public static void youHave(int numOfKeychains) {
        String keychains = " keychains.";
        if (numOfKeychains == 1) keychains = " keychain.";
        System.out.println("You have " + numOfKeychains + keychains);
    }
    
//    public static void view_order( int num_keychains, double price_per_keychain, double tax, int base_shipping, int per_keychain_shipping )
//            the number of keychains in the order, the price per keychain, the shipping charges on the order, 
//            the subtotal before tax, the tax on the order, and the final cost of the order.
            
    public static void view_order(int numOfKeychains, int priceOfKeychains, double tax, int base_shipping, int per_keychain_shipping) {
        youHave(numOfKeychains);
        System.out.println("Keychains cost $" + priceOfKeychains + " each.");
        System.out.println("Base shipping cost is $" + base_shipping + ", plus an additional $" + per_keychain_shipping + " for each keychain.");
        int subtotal = (numOfKeychains * priceOfKeychains) + base_shipping + (per_keychain_shipping * numOfKeychains);
        System.out.println("Subtotal before tax comes to: $" + subtotal);
        DecimalFormat decf = new DecimalFormat("0.00");
        
        System.out.println("With a tax of " + tax + "%, the total cost comes to: $" + decf.format(subtotal * (1 + tax / 100)));      
    }
    
    public static void checkout(int numOfKeychains, int priceOfKeychains, double tax, int base_shipping, int per_keychain_shipping) {
        if (numOfKeychains > 0) {
            System.out.print("What is your name? ");
            Scanner scan = new Scanner(System.in);
            String name = scan.nextLine();
            view_order(numOfKeychains, priceOfKeychains, tax, base_shipping, per_keychain_shipping);
            System.out.println("Thanks for your order, " + name + "!");
        } else {
            System.out.println("Come again, and buy something next time...");
        }
    }
}