package com.jorypestorious.addressbook.ui;

import com.jorypestorious.addressbook.dto.Address;
import java.util.HashMap;

public class UI {
    
    public void listAddresses(HashMap<String, Address> addressBook) {
        System.out.println("         Addresses         \n" +
                           "---------------------------\n");
        
        for (String lastName : addressBook.keySet()) {
            System.out.print(addressBook.get(lastName) + "\n\n");
        }
        
        System.out.println("---------------------------\n");
    }

}
