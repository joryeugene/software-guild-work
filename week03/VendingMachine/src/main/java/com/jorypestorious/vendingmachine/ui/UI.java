package com.jorypestorious.vendingmachine.ui;

import com.jorypestorious.vendingmachine.dto.Item;
import java.util.HashMap;

public class UI {
    
    public void displayItem(Item i) {
        System.out.println("\n" + i);
    }
    
    public void displayInventory(HashMap<String, Item> inv) {
        System.out.println("\n      Vending Machine        \n" +
                           "-------------------------------\n");
        
        for (String name : inv.keySet()) {
            System.out.println(inv.get(name) + "\n");
        }
        
        System.out.println("-------------------------------\n");
    }

}
