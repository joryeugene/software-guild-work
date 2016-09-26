package com.jorypestorious.addressbook.controller;

import com.jorypestorious.addressbook.dao.Data;
import com.jorypestorious.addressbook.ui.ConsoleIO;
import com.jorypestorious.addressbook.ui.UI;

public class Controller {
    
    private final ConsoleIO io;
    private final Data data;
    private final UI ui;
    
    public Controller(String filename) {
        data = new Data(filename);
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "        ADDRESS BOOK\n" +
                            "============================\n" +
                            "1. Add an Address\n" +
                            "2. Delete an Address\n" +
                            "3. Find an Address\n" +
                            "4. List Number of Addresses\n" +
                            "5. List All Addresses\n" +
                            "6. Edit an Address\n" +
                            "7. Exit the Program\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 1, 7);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    String firstName = io.promptString("First Name: ");
                    String lastName = io.promptString("Last Name: ");
                    String street = io.promptString("Street Address: ");
                    io.promptString("First Name: ");
                    io.promptString("First Name: ");
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    String addresses = " are " + data.getNumOfAddresses() + " addresses ";
                    if (data.getNumOfAddresses() == 1) addresses = " is 1 address ";
                    io.display("There" + addresses + "in the book.\n");
                    break;
                case 5:
                    ui.listAddresses(data.getAddressBook());
                    break;
                case 6:
                    break;
                case 7:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
    }

}


        
        