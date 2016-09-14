package com.jorypestorious.pbd.ifstatements;

public class WhatIf {
    public static void main(String[] args) {
        int people = 20;
        int cats = 30;
        int dogs = 15;
        
        // If the statement evaluates as true in the IF statement, the code in the curly braces will be executed
        
        /* The curly braces are not needed if just one statement or expression is after the IF statement 
           but is usually used anyways and is needed if there is more than one statement. 
           The braces block off what will be executed if the statement evaluates as true
        */
        if ( people > cats ) {
            System.out.println( "Too many cats!  The world is doomed!" );
        }
        
        if ( people > cats ) {
            System.out.println( "Not many cats!  The world is saved!" );
        }
        
        if ( people < dogs ) {
            System.out.println( "The world is drooled on!" );
        }
        
        if ( people > dogs ) {
            System.out.println( "The world is dry!" );
        }
        
        dogs += 5;
        
        if ( people >= dogs ) {
            System.out.println( "People are greater than or equal to dogs." );
        }
        
        if ( people <= dogs ) {
            System.out.println( "People are less than or equal to dogs." );
        }
        
        if ( people == dogs ) {
            System.out.println( "People are dogs." );
        }
    }
}
