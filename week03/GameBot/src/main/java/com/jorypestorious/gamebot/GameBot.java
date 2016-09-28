package com.jorypestorious.gamebot;

import com.jorypestorious.gamebot.games.Blackjack;
import com.jorypestorious.gamebot.games.Game;
import com.jorypestorious.gamebot.games.Hangman;
import com.jorypestorious.gamebot.games.LuckySevens;
import com.jorypestorious.gamebot.games.RockPaperScissors;
import com.jorypestorious.gamebot.games.TicTacToe;
import com.jorypestorious.gamebot.ui.ConsoleIO;

public class GameBot {
    
    public static void main(String[] args) {
        
        ConsoleIO io = new ConsoleIO();
        
        Game[] games = {new Hangman(), new TicTacToe(), new Blackjack(), new RockPaperScissors(), new LuckySevens()};
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            
            io.display(""); // line break
            
            io.display("        GAME BOT        \n" +
                       "========================");
            
            for (int i = 0; i < games.length; i++) {
                io.display((i+1) + ". " + games[i].getTitle());
            }
            
            io.display((games.length+1) + ". Exit\n");
            
            int selection = io.promptInt("> Enter Game Selection: ", 1, games.length+1);

            if (selection == games.length+1) {
                keepRunning = false;
            } else {
                io.display(""); // line break
                games[selection-1].run();
            }
            
        }
        
        io.display("\nGOOD BYE!");
    }

}
