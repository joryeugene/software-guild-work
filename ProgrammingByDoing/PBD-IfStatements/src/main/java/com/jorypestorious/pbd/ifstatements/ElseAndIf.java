package com.jorypestorious.pbd.ifstatements;

public class ElseAndIf {
    public static void main(String[] args) {
        int people = 30;
        int cars = 40;
        int buses = 15;
        
// The else if gives an alternative statement to evaluate if its true and possibly execute the code, if not ELSE is the fallback
// If you remove an ELSE from an ELSE IF statement, it will evaluate as a new separate IF block
        if ( cars > people ) {
            System.out.println( "We should take the cars." );
        } if ( cars < people ) {
            System.out.println( "We should not take the cars." );
        } else {
            System.out.println( "We can't decide." );
        }
        
        if ( buses > cars ) {
            System.out.println( "That's too many buses." );
        } else if ( buses < cars ) {
            System.out.println( "Maybe we could take the buses." );
        } else {
            System.out.println( "We still can't decide." );
        }
        
        if ( people > buses ) {
            System.out.println( "All right, let's just take the buses." );
        } else {
            System.out.println( "Fine, let's stay home then." );
        }
    }
}
