package com.jorypestorious.statecapitals;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

class Capital {
    String name;
    int population;
    double size; // mi2
    
    Capital (String name, int pop, double size) {
        this.name = name;
        this.population = pop;
        this.size = size;
    }
}

public class StateCapitals2 {
    
    public static void main(String[] args) {
        HashMap<String, Capital> statesAndCapitals = new HashMap<>();
        statesAndCapitals.put("Alabama", new Capital("Montgomery", 205764, 155.4));
        statesAndCapitals.put("Alaska", new Capital("Juneau", 31275, 2716.7));
        statesAndCapitals.put("Arizona", new Capital("Phoenix", 1445632, 474.9)); //
        statesAndCapitals.put("Arkansas", new Capital("Little Rock", 193524, 116.2));
        statesAndCapitals.put("California", new Capital("Sacramento", 466488, 97.2));
        statesAndCapitals.put("Colorado", new Capital("Denver", 600158, 153.4));
        statesAndCapitals.put("Connecticut", new Capital("Hartford", 124775, 17.3));
        statesAndCapitals.put("Delaware", new Capital("Dover", 36047, 22.4));
        statesAndCapitals.put("Florida", new Capital("Tallahassee", 181412, 95.7));
        statesAndCapitals.put("Georgia", new Capital("Atlanta", 420003, 131.7));
        
        statesAndCapitals.put("Hawaii", new Capital("Honolulu", 337256, 85.7));
        statesAndCapitals.put("Idaho", new Capital("Boise", 205671, 63.8));
        statesAndCapitals.put("Illinois", new Capital("Springfield", 116250, 54.0));
        statesAndCapitals.put("Indiana", new Capital("Indianapolis", 829718, 361.5));
        statesAndCapitals.put("Iowa", new Capital("Des Moines", 203433, 75.8));
        statesAndCapitals.put("Kansas", new Capital("Topeka", 127473, 56.0));
        statesAndCapitals.put("Kentucky", new Capital("Frankfort", 25527, 14.7));
        statesAndCapitals.put("Louisiana", new Capital("Baton Rouge", 229553, 76.8));
        statesAndCapitals.put("Maine", new Capital("Augusta", 19136, 55.4));
        statesAndCapitals.put("Maryland", new Capital("Annapolis", 38394, 6.73));
        
        statesAndCapitals.put("Massachusetts", new Capital("Boston", 617594, 48.4));
        statesAndCapitals.put("Michigan", new Capital("Lansing", 114297, 35.0));
        statesAndCapitals.put("Minnesota", new Capital("Saint Paul", 285068, 52.8));
        statesAndCapitals.put("Mississippi", new Capital("Jackson", 173514, 104.9));
        statesAndCapitals.put("Missouri", new Capital("Jefferson City", 43079, 27.3));
        statesAndCapitals.put("Montana", new Capital("Helena", 28190, 14.0));
        statesAndCapitals.put("Nebraska", new Capital("Lincoln", 258379, 74.6));
        statesAndCapitals.put("Nevada", new Capital("Carson City", 55274, 143.4));
        statesAndCapitals.put("New Hampshire", new Capital("Concord", 42695, 64.3));
        statesAndCapitals.put("New Jersey", new Capital("Trenton", 84913, 7.66));
        
        statesAndCapitals.put("New Mexico", new Capital("Santa Fe", 75764, 37.3));
        statesAndCapitals.put("New York", new Capital("Albany", 97856, 21.4));
        statesAndCapitals.put("North Carolina", new Capital("Raleigh", 403892, 114.6));
        statesAndCapitals.put("North Dakota", new Capital("Bismarck", 61272, 26.9));
        statesAndCapitals.put("Ohio", new Capital("Columbus", 822553, 210.3));
        statesAndCapitals.put("Oklahoma", new Capital("Oklahoma City", 580000, 607.0));
        statesAndCapitals.put("Oregon", new Capital("Salem", 154637, 45.7));
        statesAndCapitals.put("Pennsylvania", new Capital("Harrisburg", 49528, 8.11));
        statesAndCapitals.put("Rhode Island", new Capital("Providence", 178042, 18.5));
        statesAndCapitals.put("South Carolina", new Capital("Columbia", 131686, 125.2));
        
        statesAndCapitals.put("South Dakota", new Capital("Pierre", 13646, 13.0));
        statesAndCapitals.put("Tennessee", new Capital("Nashville", 635710, 473.3));
        statesAndCapitals.put("Texas", new Capital("Austin", 790390, 251.5));
        statesAndCapitals.put("Utah", new Capital("Salt Lake City", 186440, 109.1));
        statesAndCapitals.put("Vermont", new Capital("Montpelier", 7855, 10.2));
        statesAndCapitals.put("Virginia", new Capital("Richmond", 204214, 60.1));
        statesAndCapitals.put("Washington", new Capital("Olympia", 46478, 16.7));
        statesAndCapitals.put("West Virginia", new Capital("Charleston", 51400, 31.6));
        statesAndCapitals.put("Wisconsin", new Capital("Madison", 233209, 68.7));
        statesAndCapitals.put("Wyoming", new Capital("Cheyenne", 59466, 21.1));
        
        DecimalFormat df = new DecimalFormat("#,###,###");
        
        for (String state : statesAndCapitals.keySet()) {
            System.out.print(state);
            if (state.length() < 8) System.out.print("\t\t");
            else System.out.print("\t");
            
            System.out.print(statesAndCapitals.get(state).name);
            if (statesAndCapitals.get(state).name.length() < 8) System.out.print("\t\t");
            else System.out.print("\t");
            
            System.out.print(" | Pop: " + df.format(statesAndCapitals.get(state).population));
            if (Integer.toString(statesAndCapitals.get(state).population).length() < 7) System.out.print("\t\t");
            else System.out.print("\t");
            
            System.out.println(" | Size: " + statesAndCapitals.get(state).size + " mi2");
        }
               
        Scanner scan = new Scanner(System.in);
        int input;
        int count;
        boolean keepRunning = true;
        
        do {
            count = 0;
            System.out.print("\nPrint out states with a capital population above (or 0 to exit): ");
            
            while (!scan.hasNextInt()) {
                System.out.print("Enter a real number: ");
                scan.next();
            }
            
            input = scan.nextInt();
            
            System.out.println("===========================================================================\n");
            
            if (input == 0) {
                keepRunning = false;
            } else {
                
                for (String state : statesAndCapitals.keySet()) {
                    if (statesAndCapitals.get(state).population > input) {
                        count++;                        
                    
                        System.out.print(state);
                        if (state.length() < 8) System.out.print("\t\t");
                        else System.out.print("\t");
                        
                        System.out.print(statesAndCapitals.get(state).name);
                        if (statesAndCapitals.get(state).name.length() < 8) System.out.print("\t\t");
                        else System.out.print("\t");
                        
                        System.out.print(" | Pop: " + df.format(statesAndCapitals.get(state).population));
                        if (Integer.toString(statesAndCapitals.get(state).population).length() < 7) System.out.print("\t\t");
                        else System.out.print("\t");
                        
                        System.out.println(" | Size: " + statesAndCapitals.get(state).size + " mi2");
                    }
                }
                
                if (count > 0) {
                    System.out.println("\n" + count + " capitals with a population above " + df.format(input));
                } else {
                    System.out.println("None.");
                }
                
            }
            
        } while (keepRunning);
        
    }
}