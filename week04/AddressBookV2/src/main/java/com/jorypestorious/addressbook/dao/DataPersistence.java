package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataPersistence {
    
    public List fileToHashMap(String filename) {
        List<Address> addressBook = new ArrayList<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
            
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                addressBook.add(new Address(currentLine[0], currentLine[1], currentLine[2],
                        currentLine[3], currentLine[4], Integer.parseInt(currentLine[5])));
            }
            
        } catch (FileNotFoundException e) {
            // empty addressBook
        }
        
        return addressBook;
    }
    
    public boolean saveToFile(List<Address> addressBook, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            addressBook.stream()
                    .forEach(a -> write.println(a.getFirstName() + "::" + a.getLastName() + "::" +
                                                a.getStreet()  + "::" + a.getCity() + "::" + 
                                                a.getState() + "::" + a.getZipcode()));
            
            write.flush();
            write.close();
            
            return true;
        
        } catch (IOException e) {
            
            return false;
        }
    }
}
