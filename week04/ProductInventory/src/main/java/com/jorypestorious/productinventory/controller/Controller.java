package com.jorypestorious.productinventory.controller;

import com.jorypestorious.productinventory.dao.DAO;
import com.jorypestorious.productinventory.ui.ConsoleIO;
import com.jorypestorious.productinventory.ui.UI;

public class Controller {
    
    UI ui;
    DAO dao;
    ConsoleIO io;
    
    public Controller(DAO dao) {
        this.dao = dao;
        ui = new UI();
        io = new ConsoleIO();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n     STORE INVENTORY\n" +
                            "=============================\n" +
                            "1. View Entire Inventory\n" +
                            "2. View Products by Category\n" +
                            "3. View Products by Brand Name\n" +
                            "4. View/Edit Product by ID\n" +
                            "5. Add Product\n" +
                            "6. Find Products to Restock\n" +
                            "7. Exit the Program\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 1, 7);
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
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
    }
    

}
