package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPersistence {
    
    public Map fileToHashMap(String filename) {
        Map<String, DVD> dvdLibrary = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                dvdLibrary.put(currentLine[0], new DVD(currentLine[0], Integer.parseInt(currentLine[1]), currentLine[2],
                        currentLine[3], currentLine[4], currentLine[5]));
            }
            
        } catch (FileNotFoundException e) {
            // empty dvdLibrary
        }
        
        return dvdLibrary;
    }
    
    public boolean saveToFile(Map<String, DVD> d, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            for (String title : d.keySet()) {
                write.println(d.get(title).getTitle() + "::" + d.get(title).getYear() + "::" + d.get(title).getMpaa()  + "::" +
                              d.get(title).getDirector() + "::" + d.get(title).getStudio() + "::" + d.get(title).getNote());
            }
            
            write.flush();
            write.close();
            
            return true;
        
        } catch (IOException e) {
            
            return false;
        }
    }
}
