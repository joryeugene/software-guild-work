package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class DisplayingSomeMultiples {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a number: ");
        int num = scan.nextInt();
        
        System.out.println(""); // line break

        for (int i = 1; i <= 12; i++) {
            System.out.println(num + "x" + i + " = " + (num * i));
        }
    }

}
