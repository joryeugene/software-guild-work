package com.jorypestorious.floormastery.controller;

import com.jorypestorious.floormastery.dao.OrderDAO;
import com.jorypestorious.floormastery.ui.ConsoleIO;
import com.jorypestorious.floormastery.ui.UI;

public class Controller {
    
    OrderDAO dao;
    ConsoleIO io;
    UI ui;
    
    public Controller(OrderDAO dao) {
        this.dao = dao;
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        
        boolean keepRunning = true;
        
        String menuPrompt = "\n       SWC Corp Flooring       \n" +
                          "===============================\n" +
                          "1. Display Order(s) by Date    \n" +
                          "2. Add an Order                \n" +
                          "3. Edit an Order               \n" +
                          "4. Remove an Order             \n" +
                          "5. Exit               \n\n" +
                          "> Selection: ";
        
        while (keepRunning) {
            
            int selection = io.promptInt(menuPrompt, 1, 5);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        io.display("Goodbye.");
        
    }

}
