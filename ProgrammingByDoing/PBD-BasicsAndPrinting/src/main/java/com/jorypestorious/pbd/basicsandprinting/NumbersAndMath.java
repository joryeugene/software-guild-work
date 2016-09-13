package com.jorypestorious.pbd.basicsandprinting;

public class NumbersAndMath {
    public static void main(String[] args) {
        System.out.println( "I will now count my chickens:" );
        // 30 / 6 and then add 25... 30
        System.out.println( "Hens " + ( 25 + 30.0 / 6.0 ) );
        // 25 * 3 and then divide by 4 and the remainder is 3 and 100 - 3 is 97
        System.out.println( "Roosters " + ( 100 - 25.0 * 3.0 % 4.0 ) );
        
        System.out.println( "Now I will count the eggs:" );
        // This one confuses me
        System.out.println( 3 + 2 + 1 - 5 + 4.0 % 2.0 - 1.0 / 4.0 + 6 );
        
        System.out.println( "Is it true that 3 + 2 < 5 - 7?" );
        // 5 < -2 false
        System.out.println( 3.0 + 2.0 < 5.0 - 7.0 );
        // easy
        System.out.println( "What is 3 + 2? " + ( 3.0 + 2.0 ) );
        System.out.println( "What is 5 - 7? " + ( 5.0 - 7.0 ) );
        // -2
        System.out.println( "Oh, that's why it's false." );
        
        System.out.println( "How about some more." );
        // true
        System.out.println( "Is it greater? " + ( 5.0 > -2.0 ) );
        // true
        System.out.println( "Is it greater or equal? " + ( 5.0 >= -2.0 ) );
        // false
        System.out.println( "Is it less or equal? " + ( 5.0 <= -2.0 ) );
    }
}
