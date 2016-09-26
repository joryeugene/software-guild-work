package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class DataAccess {
    
    public HashMap fileToHashMap(String filename) {
        HashMap<String, Address> addressBook = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                addressBook.put(currentLine[1], new Address(currentLine[0], currentLine[1], currentLine[2],
                        currentLine[3], currentLine[4], Integer.parseInt(currentLine[5])));
            }
            
        } catch (FileNotFoundException e) {
            // empty addressBook
        }
        
        return addressBook;
    }

}
