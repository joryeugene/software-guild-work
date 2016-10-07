package com.jorypestorious.addressbook.ui;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;
import java.util.Map;

public class UI {
    
    public void listAddresses(List<Address> addressBook) {
        System.out.println("\n         Addresses         \n" +
                           "---------------------------\n");
        
        for (int i = 0; i < addressBook.size(); i++) {
            System.out.print(addressBook.get(i) + "\n\n");
        }
        
        System.out.println("---------------------------\n");
    }
    
    public void listAddresses(Map<String, List<Address>> addressBook) {
        System.out.println("\n         Addresses         \n" +
                           "---------------------------\n");
        
        for (String city : addressBook.keySet()) {
            System.out.println(">>>> " + city + " <<<<");
            
            for (int i = 0; i < addressBook.get(city).size(); i++) {
                System.out.print(addressBook.get(city).get(i) + "\n\n");
            }
        }
        
        System.out.println("---------------------------\n");
    }
    
    public void displayAddress(Address a) {
        System.out.println(a);
    }

}
