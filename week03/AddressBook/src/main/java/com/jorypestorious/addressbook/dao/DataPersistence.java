package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
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
        Map<String, Address> addressBook = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                addressBook.put(currentLine[0] + " " + currentLine[1], new Address(currentLine[0], currentLine[1], currentLine[2],
                        currentLine[3], currentLine[4], Integer.parseInt(currentLine[5])));
            }
            
        } catch (FileNotFoundException e) {
            // empty addressBook
        }
        
        return addressBook;
    }
    
    public boolean saveToFile(Map<String, Address> a, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            for (String name : a.keySet()) {
                write.println(a.get(name).getFirstName() + "::" + a.get(name).getLastName() + "::" + a.get(name).getStreet()  + "::" +
                              a.get(name).getCity() + "::" + a.get(name).getState() + "::" + a.get(name).getZipcode());
            }
            
            write.flush();
            write.close();
            
            return true;
        
        } catch (IOException e) {
            
            return false;
        }
    }
}
