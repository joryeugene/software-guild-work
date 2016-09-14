package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class ChooseYourOwnAdventure {
    public static void main(String[] args) {
        System.out.println("WELCOME TO JORY'S TINY ADVENTURE!\n");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Go to school or park?\n>");
        String q1 = scan.nextLine();
        
        if (q1.equals("school")) {
            System.out.print("\nYou are at school. Do you study art or science?\n>");
            String q2 = scan.nextLine();
            if (q2.equals("art")) {
                System.out.print("\nYou are studying art. Do you draw or sculpt?\n>");
                String q3 = scan.nextLine();
                if (q3.equals("draw")) {
                    System.out.print("\nYou draw a beautiful picture and your mommy puts it on the fridge.");
                } else if (q3.equals("sculpt")) {
                    System.out.print("\nYou sculpt an amazing coffee cup and give it to your mommy for Christmas.");
                } else {
                    System.out.print("\nINPUT ERROR");
                    System.exit(0);
                }
            } else if (q2.equals("science")) {
                System.out.print("\nYou are studying science. Do you specialize in genetics or computers?\n>");
                String q3 = scan.nextLine();
                if (q3.equals("genetics")) {
                    System.out.print("\nYou create the 'perfect' human being, but it ends up taking over the world. Thanks.");
                } else if (q3.equals("computers")) {
                    System.out.print("\nYou create an AI that takes over the world. Thanks.");
                } else {
                    System.out.print("\nINPUT ERROR");
                    System.exit(0);
                }
            } else {
                System.out.print("\nINPUT ERROR");
                System.exit(0);
            }
        } else if (q1.equals("park")) {
            System.out.print("\nYou are at the park. Do you want to skateboard or rollerblade?\n>");
            String q2 = scan.nextLine();
            if (q2.equals("skateboard")) {
                System.out.print("\nYou are skateboarding. Do you kickflip or ollie?\n>");
                String q3 = scan.nextLine();
                if (q3.equals("kickflip")) {
                    System.out.print("\nYou miss up the trick, fall on your face, and break your face. Great job.");
                } else if (q3.equals("ollie")) {
                    System.out.print("\nYou land on a butterfly and cause a chain reaction that destorys the environment. Thanks.");
                } else {
                    System.out.print("\nINPUT ERROR");
                    System.exit(0);
                }
            } else if (q2.equals("rollerblade")) {
                System.out.print("\nYou are rollerblading. Do you go right or left?\n>");
                String q3 = scan.nextLine();
                if (q3.equals("right")) {
                    System.out.print("\nYou stumble into your soulmate and live happily ever after.");
                } else if (q3.equals("left")) {
                    System.out.print("\nYou fall down a manhole and die a weird, stupid death.");
                } else {
                    System.out.print("\nINPUT ERROR");
                    System.exit(0);
                }
            } else {
                System.out.print("\nINPUT ERROR");
                System.exit(0);
            }
        } else {
            System.out.print("\nINPUT ERROR");
            System.exit(0);
        }
        
//        System.out.println("\n");
    }
}
