package com.jorypestorious.pokemonleague.ui;

import java.util.List;
import java.util.Map;

public class UI {
    
    public void displayTeams(Map<String, List<String>> league) {
        for (String name : league.keySet()) {
            System.out.println(name);
        }
    }
    
    public void displayPlayers(List<String> players) {
        for (String name : players) {
            System.out.println(name);
        }
    }
    
    public void displayTeamsAndPlayers(Map<String, List<String>> league) {
        for (String name : league.keySet()) {
            for (int i = 0; i < league.get(name).size(); i++) {
                System.out.print(name);
                System.out.print("\t");
                System.out.println(league.get(name).get(i));
            }
            
            if (league.get(name).size() < 1) {
                System.out.print(name);
                System.out.print("\t");
                System.out.println("! No Active Members");
            }
        }
    }
    

}
