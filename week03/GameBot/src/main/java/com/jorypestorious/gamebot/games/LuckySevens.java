package com.jorypestorious.gamebot.games;

import com.jorypestorious.gamebot.ui.ConsoleIO;
import java.util.Random;
import java.util.Scanner;

public class LuckySevens implements Game {

    @Override
    public String getTitle() {
        return "Lucky Sevens";
    }
    
    @Override
    public void run() {
        
        ConsoleIO io = new ConsoleIO();
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        
        io.display("        LUCKY SEVENS    \n" +
                   "============================");
        
        
        int bet = io.promptInt("How many dollars do you have? ", 1, 10000),
            initialBet = bet,
            max = bet,
            rollsAtMax = 0,
            totalRolls = 0;
        
        while (bet > 0) {
            totalRolls++;
            if (1 + r.nextInt(6) == 1 + r.nextInt(6)) {
                bet +=  4;
                if (max < bet) {
                    max = bet;
                    rollsAtMax = totalRolls;
                }
                
            } else {
                bet--;
            }
        }
        
        String rollsAtMaxMsg;
        if (initialBet == max) {
            rollsAtMaxMsg = "at the beginning";
        } else {
            rollsAtMaxMsg = "after " + rollsAtMax + " rolls";
        }
        
        io.display("\nYou went broke after " + totalRolls + " rolls.\n");
        io.display("You should have quit " + rollsAtMaxMsg + " when you had $" + max + ".");
    }

}
