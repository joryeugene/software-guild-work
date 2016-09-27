package com.jorypestorious.vendingmachine.controller;

import com.jorypestorious.vendingmachine.dao.Inventory;
import com.jorypestorious.vendingmachine.ui.ConsoleIO;
import com.jorypestorious.vendingmachine.ui.UI;

public class Controller {
    
    private final ConsoleIO io;
    private final Inventory dao;
    private final UI ui;
    
    public Controller(String filename) {
        dao = new Inventory(filename);
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n1. View Complete Library\n" +
                              "2. Find DVD by Title\n" +
                              "3. Add a DVD\n" +
                              "4. Remove a DVD\n" +
                              "5. Exit\n\n" +
                              "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            ui.displayInventory(dao.getInventory());
            double money = io.promptDouble("> Insert Money: ", 0.01, 100);
            //insert money
            //int selection = io.promptInt(menuPrompt, 1, 5);
            io.display(""); // line break
            
//            switch (selection) {
//                case 1:
//                    
//                    break;
//                case 2:
//                    
//                    break;
//                case 3:
//                    
//                    break;
//                case 4:
//                    
//                    break;
//                case 5:
//                    keepRunning = false;
//            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
    }

}
