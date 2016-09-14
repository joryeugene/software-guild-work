package com.jorypestorious.pbd.randomnumbers;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
         Random r = new Random();
        
        int choice = 1 + r.nextInt(6);
        String response = "";
        
        if ( choice == 1 )
            response = "You will find happiness with a new love.";
        else if ( choice == 2 )
            response = "You will win the lottery very soon.";
        else if ( choice == 3 )
            response = "Adventure is coming your way.";
        else if ( choice == 4 )
            response = "Keep an eye out for a potential windfall of money.";
        else if ( choice == 5 )
            response = "Don't eat anything red for two weeks!";
        else if ( choice == 6 )
            response = "If you meet someone who's name starts with a 'J', it was ment to be.";
        else
            response = "ERROR!";
        
        System.out.println( "Fortune cookie says: \"" + response + "\"");
    }
}
