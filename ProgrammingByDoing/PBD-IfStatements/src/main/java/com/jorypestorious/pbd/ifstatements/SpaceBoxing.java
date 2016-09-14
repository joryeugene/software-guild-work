package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class SpaceBoxing {
    
    private static int calcWeightOnPlanet(int weight, int planet) {
        int calculatedWeight = weight;
        if (planet == 1) {
            calculatedWeight *= 0.78;
        } else if (planet == 2) {
            calculatedWeight *= 0.39;
        } else if (planet == 3) {
            calculatedWeight *= 2.65;
        } else if (planet == 4) {
            calculatedWeight *= 1.17;
        } else if (planet == 5) {
            calculatedWeight *= 1.05;
        } else if (planet == 6) {
            calculatedWeight *= 1.23;
        } else {
            calculatedWeight = -100; // error
        }
        return calculatedWeight;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your current earth weight in pounds (as an integer): ");
        int weight = scan.nextInt();
        
        System.out.println("\nI have information for the following planets:");
        System.out.println("   1. Venus   2. Mars    3. Jupiter");
        System.out.println("   4. Saturn  5. Uranus  6. Neptune");
        
        System.out.print("\nWhich planet are you visiting? ");
        int planet = scan.nextInt();
        
        int calculatedWeight = calcWeightOnPlanet(weight, planet);
        
        if (calculatedWeight == -100){
            System.out.println("\nERROR: Please only choose a planet by entering a number between 1 and 6");
        } else {
            System.out.println("\nYour weight would be " + calculatedWeight + " pounds on that planet.");
        }
    }
}
