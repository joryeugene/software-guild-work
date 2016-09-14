package com.jorypestorious.pbd.ifstatements;

public class CompareToChallenge {
    public static void main(String[] args) {
        
        // five examples which result in a number less than 0
        System.out.print("Comparing \"axe\" with \"dog\" produces ");
        int i = "axe".compareTo("dog");
        System.out.println(i);
        
        System.out.print("Comparing \"bone\" with \"stone\" produces ");
        System.out.println( "bone".compareTo("stone") );
        
        System.out.print("Comparing \"fat\" with \"skinny\" produces ");
        System.out.println( "fat".compareTo("skinny") );
        
        System.out.print("Comparing \"black\" with \"white\" produces ");
        System.out.println( "black".compareTo("white") );
        
        System.out.print("Comparing \"orange\" with \"purple\" produces ");
        System.out.println( "orange".compareTo("purple") );
        
        // five examples which result in a number greater than 0
        System.out.print("\nComparing \"applebee's\" with \"apple\" produces ");
        System.out.println( "applebee's".compareTo("apple") );
        
        System.out.print("Comparing \"plane\" with \"phone\" produces ");
        System.out.println( "plane".compareTo("phone") );
        
        System.out.print("Comparing \"truck\" with \"road\" produces ");
        System.out.println( "truck".compareTo("road") );
        
        System.out.print("Comparing \"stupid\" with \"smart\" produces ");
        System.out.println( "stupid".compareTo("smart") );
        
        System.out.print("Comparing \"Wednesday\" with \"Tuesday\" produces ");
        System.out.println( "Wednesday".compareTo("Tuesday") );
        
        // two examples which give you exactly 0
        System.out.print("\nComparing \"Monkey\" with \"Monkey\" produces ");
        System.out.println( "Monkey".compareTo("Monkey") );
        
        System.out.print("Comparing \"coffee\" with \"coffee\" produces ");
        System.out.println( "coffee".compareTo("coffee") );
    }
}
