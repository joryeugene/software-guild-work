package com.jorypestorious.addressbook.ui;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;

public class UI {
    
    public void listAddresses(List<Address> addressBook) {
        System.out.println("\n         Addresses         \n" +
                           "---------------------------\n");
        
        for (int i = 0; i < addressBook.size(); i++) {
            System.out.print("ID: " + (i+1) + "\n" + addressBook.get(i) + "\n\n");
        }
        
        System.out.println("---------------------------\n");
    }
    
    public void displayAddress(int index, Address a) {
        System.out.println("ID: " + (index+1) + "\n" + a);
    }

}
