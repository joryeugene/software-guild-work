package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class Keychains1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ye Olde Keychain Shoppe");
        boolean keepRunning = true;

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
                    add_keychains();
                    break;
                case 2:
                    remove_keychains();
                    break;
                case 3:
                    view_order();
                    break;
                case 4:
                    checkout();
                    keepRunning = false;
                    break;
                default:
                    keepRunning = false;
            }
        }
    }
    
    public static void add_keychains() {
        System.out.println("ADD KEYCHAINS");
    }
    
    public static void remove_keychains() {
        System.out.println("REMOVE KEYCHAINS");
    }
    
    public static void view_order() {
        System.out.println("VIEW ORDER");
    }
    
    public static void checkout() {
        System.out.println("CHECKOUT");
    }
}
