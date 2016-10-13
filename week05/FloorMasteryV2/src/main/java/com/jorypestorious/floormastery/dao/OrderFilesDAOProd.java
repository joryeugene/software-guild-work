package com.jorypestorious.floormastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderFilesDAOProd implements OrderFilesDAO {
    
    @Override
    public List<String> getOrderListFileNames() {
        List<String> fileNames = new ArrayList<>();
        
        try ( Scanner scanFile = new Scanner(new BufferedReader( new FileReader("Data/OrderListFileNames.txt") )) ) {
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    fileNames.add(currentLine.trim());
                }
            }
            
            scanFile.close();
            
        } catch (FileNotFoundException ex) {
            // returns an empty list
        }
        
        return fileNames;
    }
    
    @Override
    public void saveOrderListFileNames(List<String> orderListFileNames) {
        try ( PrintWriter write = new PrintWriter(new FileWriter("Data/OrderListFileNames.txt")) ) {
            orderListFileNames.stream().forEach(fileName -> write.println(fileName));
            write.flush();
            write.close();
            
        } catch (IOException e) {
            System.out.println("! Error Saving Order Lists Filename Data to File");
        }
    }

}
