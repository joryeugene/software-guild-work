package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class Refresher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scan.nextLine();
        
        System.out.println(""); // line break
        
        for (int i = 0; i < 10; i++) {
            System.out.println(name);
            if (name.equals("Mitchell") && i == 4) break;
        }
    }
}
