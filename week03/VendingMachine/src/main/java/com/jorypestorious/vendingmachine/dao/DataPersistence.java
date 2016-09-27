package com.jorypestorious.vendingmachine.dao;

import com.jorypestorious.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DataPersistence {
    
    public HashMap fileToHashMap(String filename) {
        HashMap<String, Item> inventory = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                inventory.put(currentLine[0], new Item(currentLine[0], Double.parseDouble(currentLine[1]), Integer.parseInt(currentLine[2])));
            }
            
        } catch (FileNotFoundException e) {
            // empty inventory
        }
        
        return inventory;
    }
    
    public boolean saveToFile(HashMap<String, Item> inv, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            for (String name : inv.keySet()) {
                write.println(inv.get(name).getName() + "::" + inv.get(name).getCost()+ "::" + inv.get(name).getCount());
            }
            
            write.flush();
            write.close();
            
            return true;
        
        } catch (IOException e) {
            
            return false;
        }
    }
}
