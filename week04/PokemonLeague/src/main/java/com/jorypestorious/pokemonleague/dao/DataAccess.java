package com.jorypestorious.pokemonleague.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataAccess {
    
    public Map fileToHashMap(String filename) {
        Map<String, List<String>> league = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                
                if (league.containsKey(currentLine[0])) {
                    league.get(currentLine[0]).add(currentLine[1]);
                } else {
                    league.put(currentLine[0], new ArrayList<>());
                    league.get(currentLine[0]).add(currentLine[1]);
                }
            }
            
        } catch (FileNotFoundException e) {
            // empty league
        }
        
        return league;
    }
    
    public boolean saveToFile(Map<String, List<String>> league, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            for (String teamName : league.keySet()) {
                
                for (int i = 0; i < league.get(teamName).size(); i++) {
                    write.println(teamName + "::" + league.get(teamName).get(i));
                }
                
            }
            
            write.flush();
            write.close();
            
            return true;
        
        } catch (IOException e) {
            
            return false;
        }
    }
}