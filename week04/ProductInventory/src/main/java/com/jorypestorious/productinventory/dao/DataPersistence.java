package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Ball;
import com.jorypestorious.productinventory.dto.Product;
import com.jorypestorious.productinventory.dto.Racquet;
import com.jorypestorious.productinventory.dto.Shoe;
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
    
    public Map fileToInventory(String filename) {
        Map<Integer, Product> inventory = new HashMap<>();
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
            
            Product.setProductId(scanFile.nextInt());
        
            while (scanFile.hasNextLine()) {
                String[] currentLine = scanFile.nextLine().split("::");
                String category = currentLine[0];
                
                switch (category) { ///////////// Need to add need Product subclasses here /////////////
                    case "Racquet":
                        inventory.put(Integer.parseInt(currentLine[1]), 
                                new Racquet(Integer.parseInt(currentLine[1]), currentLine[2], currentLine[3],
                                currentLine[4], currentLine[5],
                                Double.parseDouble(currentLine[6]), Integer.parseInt(currentLine[7])));
                        break;
                    case "Ball":
                        inventory.put(Integer.parseInt(currentLine[1]), 
                                new Ball(Integer.parseInt(currentLine[1]), currentLine[2], currentLine[3],
                                currentLine[4], Double.parseDouble(currentLine[5]), Integer.parseInt(currentLine[6])));
                        break;
                    case "Shoe":
                        inventory.put(Integer.parseInt(currentLine[1]), 
                                new Shoe(Integer.parseInt(currentLine[1]), currentLine[2], currentLine[3],
                                currentLine[4], currentLine[5],
                                Double.parseDouble(currentLine[6]), Integer.parseInt(currentLine[7])));
                        break;
                    case "General":
                        inventory.put(Integer.parseInt(currentLine[1]), 
                                new Product(Integer.parseInt(currentLine[1]), currentLine[2], currentLine[3],
                                Double.parseDouble(currentLine[4]), Integer.parseInt(currentLine[5])));
                        break;
                    default:
                }
                
            }
            
        } catch (FileNotFoundException e) {
            // empty inventory
        }
        
        return inventory;
    }
    
    public boolean saveToFile(Map<Integer, Product> inv, String filename) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(filename));
            
            if (inv.size() > 0) {
                write.println(Product.getCurrentProductId()+1);
                
                for (Integer id : inv.keySet()) {
                    String category = inv.get(id).getCategory();
                    
                    switch (category) { ///////////// Need to add need Product subclasses here /////////////
                        case "Racquet":
                            Racquet racquet = (Racquet)inv.get(id);
                            write.println(category + "::" + racquet.getId() + "::" + racquet.getBrand()  + "::" +
                                    racquet.getName() + "::" + racquet.getWeight() + "::" + racquet.getColor() + "::" +
                                    racquet.getPrice() + "::" + racquet.getQuantity());
                            break;
                        case "Ball":
                            Ball ball = (Ball)inv.get(id);
                            write.println(category + "::" + ball.getId() + "::" + ball.getBrand()  + "::" +
                                    ball.getName() + "::" + ball.getDots() + "::" + ball.getPrice() + "::" + ball.getQuantity());
                            break;
                        case "Shoe":
                            Shoe shoes = (Shoe)inv.get(id);
                            write.println(category + "::" + shoes.getId() + "::" + shoes.getBrand()  + "::" +
                                    shoes.getName() + "::" + shoes.getSize() + "::" + shoes.getColor() + "::" +
                                    shoes.getPrice() + "::" + shoes.getQuantity());
                            break;
                        case "General":
                            Product item = inv.get(id);
                            write.println(category + "::" + item.getId() + "::" + item.getBrand()  + "::" +
                                    item.getName() + "::" + item.getPrice() + "::" + item.getQuantity());
                            break;
                        default:
                    }
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