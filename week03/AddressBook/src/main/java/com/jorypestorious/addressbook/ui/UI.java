package com.jorypestorious.addressbook.ui;

import com.jorypestorious.addressbook.dto.Address;
import java.util.Map;

public class UI {
    
    public void listAddresses(Map<String, Address> addressBook) {
        System.out.println("\n         Addresses         \n" +
                           "---------------------------\n");
        
        for (String lastName : addressBook.keySet()) {
            System.out.print(addressBook.get(lastName) + "\n\n");
        }
        
        System.out.println("---------------------------\n");
    }
    
    public void displayAddress(Address a) {
        System.out.println(a);
    }

}
