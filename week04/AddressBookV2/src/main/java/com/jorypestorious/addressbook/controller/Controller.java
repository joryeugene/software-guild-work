package com.jorypestorious.addressbook.controller;

import com.jorypestorious.addressbook.dao.DAO;
import com.jorypestorious.addressbook.dto.Address;
import com.jorypestorious.addressbook.ui.ConsoleIO;
import com.jorypestorious.addressbook.ui.UI;
import java.util.List;
import java.util.Map;

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
                            "1. List All Addresses\n" +
                            "2. Search Addresses by Last Name\n" +
                            "3. Search Addresses by City\n" +
                            "4. Search Addresses by State\n" +
                            "5. Search Addresses by Zip Code\n" +
                            "6. Add an Address\n" +
                            "7. Edit an Address\n" +
                            "8. Delete an Address\n" +
                            "9. List Number of Addresses\n" +
                            "0. Exit the Program\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 0, 9);
            io.display(""); // line break
            
//3. The user must be able to search addresses by City.
//4. The user must be able to search addresses by State.
//       a. When searching by state, the results must be sorted into separate data structures by City.
//5. The user must be able to search addresses by Zipcode.
            switch (selection) {
                case 1:
                    ui.listAddresses(dao.getAddressBook());
                    break;
                case 2:
                    searchAddressesByLastName();
                    break;
                case 3:
                    searchAddressesByCity();
                    break;
                case 4:
                    searchAddressesByState();
                    break;
                case 5:
                    searchAddressesByZip();
                    break;
                case 6:
                    addAddress();
                    break;
                case 7:
                    editAddress();
                    break;
                case 8:
                    deleteAddress();
                    break;
                case 9:
                    listNumOfAddress();
                    break;
                case 0:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
    }
    
    private void searchAddressesByLastName() {
        String last = io.promptString("Last name: ");
        List<Address> addressBookQuery = dao.searchAddressesByLastName(last);
        if (addressBookQuery.size() > 0) {
            ui.listAddresses(addressBookQuery);
        } else {
            io.display("! ERROR: Could not find an address for " + last);
        }
    }
    
    private void searchAddressesByCity() {
        String city = io.promptString("City: ");
        List<Address> addressBookQuery = dao.searchAddressesByCity(city);
        if (addressBookQuery.size() > 0) {
            ui.listAddresses(addressBookQuery);
        } else {
            io.display("! ERROR: Could not find an address in " + city);
        }
    }
    
    private void searchAddressesByState() {
        String state = io.promptStateCode("State Code: ");
        Map<String, List<Address>> addressBookQuery = dao.searchAddressesByState(state);
        if (addressBookQuery.size() > 0) {
            ui.listAddresses(addressBookQuery);
        } else {
            io.display("! ERROR: Could not find an address in " + state);
        }
    }
    
    private void searchAddressesByZip() {
        int zip = io.promptInt("Zip Code: ", 10000, 99999);
        List<Address> addressBookQuery = dao.searchAddressesByZip(zip);
        if (addressBookQuery.size() > 0) {
            ui.listAddresses(addressBookQuery);
        } else {
            io.display("! ERROR: Could not find an address with the zip code " + zip);
        }
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
        int id = io.promptInt("Entry ID: ", 0, dao.getNumOfAddresses()-1);
        String delete = io.promptString("Enter 'delete' to continue with this action: ");
        if (delete.equalsIgnoreCase("delete")) {
            dao.removeAddress(id);
            io.display("* Successfully Removed Entry");
        } else {
            io.display("! Action Canceled");
        }
    }
    
    private void listNumOfAddress() {
        String addresses = " are " + dao.getNumOfAddresses() + " addresses ";
        if (dao.getNumOfAddresses() == 1) addresses = " is 1 address ";
        io.display("There" + addresses + "in the book.\n");
    }
    
    private void editAddress() {
        if (dao.getNumOfAddresses() > 0) {
            int id = io.promptInt("Entry ID for Address to Edit: ", 0, dao.getNumOfAddresses()-1);
        
            String editPrompt = "\n           Edit\n" +
                    "--------------------------\n" +
                    "1. First Name\n" +
                    "2. Last Name\n" +
                    "3. Street Address\n" +
                    "4. City\n" +
                    "5. State Code\n" +
                    "6. Zip Code\n" +
                    "7. Back to Main Menu\n\n" +
                    "> Selection: ";
            
            Address a = (Address)dao.getAddressBook().get(id);
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
                
                dao.editAddress(id, a);
            }
            
        } else {
            io.display("! No Addresses to Edit");
        }
    }

}


        
        