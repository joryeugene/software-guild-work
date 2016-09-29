package com.jorypestorious.addressbook.controller;

import com.jorypestorious.addressbook.dao.DAO;
import com.jorypestorious.addressbook.dto.Address;
import com.jorypestorious.addressbook.ui.ConsoleIO;
import com.jorypestorious.addressbook.ui.UI;

public class Controller {
    
    private final ConsoleIO io;
    private final DAO dao;
    private final UI ui;
    
    public Controller(DAO dao) {
        this.dao = dao;
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n        ADDRESS BOOK\n" +
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
                    addAddress();
                    break;
                case 2:
                    deleteAddress();
                    break;
                case 3:
                    findAddress();
                    break;
                case 4:
                    listNumOfAddress();
                    break;
                case 5:
                    ui.listAddresses(dao.getAddressBook());
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
    }
    
    private void addAddress() {
        String firstName = io.promptString("First Name: ");
        String lastName = io.promptString("Last Name: ");
        String street = io.promptString("Street Address: ");
        String city = io.promptString("City: ");
        String state = io.promptStateCode("State Code: ");
        int zipcode = io.promptInt("Zip Code: ", 10000, 99999);
        if (dao.addAddress(new Address(firstName, lastName, street, city, state, zipcode))) {
            io.display("* Successfully added " + firstName + " " + lastName);
        } else {
            io.display("! ERROR: Could not add " + firstName + " " + lastName);
        }
    }
    
    private void deleteAddress() {
        String name = io.promptString("Full name: ");
        if (dao.removeAddress(name)) {
            io.display("* Successfully removed address for " + name);
        } else {
            io.display("! ERROR: Could not find an address for " + name);
        }
    }
    
    private void findAddress() {
        String last = io.promptString("Last name: ");
        if (dao.findAddress(last).size() > 0) {
            ui.listAddresses(dao.findAddress(last));
        } else {
            io.display("! ERROR: Could not find an address for " + last);
        }
    }
    
    private void listNumOfAddress() {
        String addresses = " are " + dao.getNumOfAddresses() + " addresses ";
        if (dao.getNumOfAddresses() == 1) addresses = " is 1 address ";
        io.display("There" + addresses + "in the book.\n");
    }
    
    private void editAddress() {
        String fullName = io.promptString("Full name for address to edit: ");
        if (dao.getAddressBook().containsKey(fullName)) {
            String editPrompt = "\n           Edit\n" +
                                  "--------------------------\n" +
                                  "1. First Name\n" +
                                  "2. Last Name\n" +
                                  "3. Street Address\n" +
                                  "4. City\n" +
                                  "5. State Code\n" +
                                  "6. Zip Code\n" +
                                  "7. Main Menu\n\n" +
                                  "> Selection: ";
            
            Address a = (Address)dao.getAddressBook().get(fullName);
            boolean keepRunning = true;
            
            while (keepRunning) {
                io.display(""); // line break
                ui.displayAddress(a);
                int selection = io.promptInt(editPrompt, 1, 7);
                io.display(""); // line break
            
                switch (selection) {
                    case 1:
                        a.setFirstName(io.promptString("First Name: "));
                        break;
                    case 2:
                        a.setLastName(io.promptString("Last Name: "));
                        break;
                    case 3:
                        a.setStreet(io.promptString("Street Address: "));
                        break;
                    case 4:
                        a.setCity(io.promptString("City: "));
                        break;
                    case 5:
                        a.setState(io.promptStateCode("State Code: "));
                        break;
                    case 6:
                        a.setZipcode(io.promptInt("Zip Code: ", 10000, 99999));
                        break;
                    case 7:
                        keepRunning = false;
                }
                
                
            }
            
            dao.editAddress(fullName, a);

        } else {
            io.display("! ERROR: Could not find an address for " + fullName);
        }
    }

}


        
        