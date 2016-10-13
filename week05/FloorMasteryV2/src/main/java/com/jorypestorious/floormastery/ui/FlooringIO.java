package com.jorypestorious.floormastery.ui;

import com.jorypestorious.floormastery.dto.Order;
import java.util.List;

public class FlooringIO {
    
    private final ConsoleIO io;
    
    public FlooringIO(ConsoleIO io) {
        this.io = io;
    }
    
    //////////////////////// Output ////////////////////////
    public void displayOrders(List<Order> orders) {
        orders.stream().forEach(o -> System.out.println("\n" + o));
    }
    
    public void displayOrdersWithFileNames(List<Order> orders) {
        orders.stream().forEach(o -> System.out.println("\n" + o.getFileName().substring(5) + "\n" + o));
    }
    
    public void displayOrder(Order order) {
        System.out.println("\n" + order);
    }
    
    //////////////////////// Input ////////////////////////
    public String getInputFromList(String prompt, List<String> list) {        
        list.add(""); // allow for blank entry
        String input = "";
        boolean invalidInput = true;
        
        do {
            if (invalidInput) input = io.promptString(prompt);
            
            for (String string : list) {
                if (string.equalsIgnoreCase(input)) invalidInput = false;
            }
            
        } while (invalidInput);
        
        return input;
    }
    
    public String getInputFromList(String prompt, String errorPrompt, List<String> list) {        
        list.add(""); // allow for blank entry
        String input = io.promptString(prompt);
        boolean invalidInput = true;
        
        do {
            
            for (String string : list) {
                if (string.equalsIgnoreCase(input)) invalidInput = false;
            }
            
            if (invalidInput) input = io.promptString(errorPrompt);
            
        } while (invalidInput);
        
        return input;
    }
}
