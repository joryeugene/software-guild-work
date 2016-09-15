package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class Adventure2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int nextroom = 1;
        String choice = "";

        while (nextroom != 0) {
            if (nextroom == 1) {
                System.out.println("You are in a small room. There is a \"closet\" and a doorway to the \"hall\".");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("closet")) {
                    nextroom = 2;
                } else if (choice.equals("hall")) {
                    nextroom = 3;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }
            if (nextroom == 2) {
                System.out.println("You're in a barren closet. There's nothing to do here except go \"back\".");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("back")) {
                    nextroom = 1;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }
            if (nextroom == 3) {
                System.out.println("You find yourself in a concrete hallway. Oddly, there is only the single");
                System.out.println("\"door\" you came through that is visible. Otherwise, the hall just extends about fifteen feet");
                System.out.println("in either direction, and ends in a smooth, blank, concrete wall.");
                System.out.println("Do you want to go back through the \"door\" or approach the \"wall\" looking for clues?");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("door")) {
                    nextroom = 1;
                } else if (choice.equals("wall")) {
                    nextroom = 4;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }
            if (nextroom == 4) {
                System.out.println("Upon closer inspection, the seemingly blank wall shimmers ever so slightly");
                System.out.println("in the dim light. You put forward a tentative hand, and it pushes through,");
                System.out.println("a feeling of static sliding up your arm.");
                System.out.println();
                System.out.println("You break through to the other side and see one tunnel diverging to the left and one to the right");
                System.out.println("Do you want to go back to the \"left\" or the \"right\"?");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("left")) {
                    nextroom = 5;
                } else if (choice.equals("right")) {
                    nextroom = 6;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }
            if (nextroom == 5) {
                System.out.println("A huge troll comes barreling out of nowhere");
                System.out.println("Do you want to \"defend\" yourself or try to \"run\" under his legs and past him?");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("defend")) {
                    System.out.println("You are a weak human. The troll easily demolishes you with his fists. You are dead");
                    nextroom = 0;
                } else if (choice.equals("run")) {
                    System.out.println("The troll is slow. You escape and make it to the end of the tunnel and into a magical heavenly land. The end.");
                    nextroom = 0;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }
            if (nextroom == 6) {
                System.out.println("A huge bear is sleeping in the middle of your path");
                System.out.println("Do you want to \"pet\" its soft fur or try to \"sneak\" past it?");
                System.out.print("> ");
                choice = keyboard.nextLine();
                if (choice.equals("pet")) {
                    System.out.println("You are a stupid human. The bear does not like to be disturbed and disposes of you quickly. You are dead");
                    nextroom = 0;
                } else if (choice.equals("sneak")) {
                    System.out.println("The are quite sneaky and make it past the bear. You make it to the end of the tunnel and into a magical heavenly land. The end.");
                    nextroom = 0;
                } else {
                    System.out.println(choice + " wasn't one of the options. Try again.");
                }
            }

        }

        System.out.println("\nGAME OVER");
    }
}
