package com.jorypestorious.productinventory;

import com.jorypestorious.productinventory.controller.MainMenu;
import com.jorypestorious.productinventory.dao.InventoryManagement;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new MainMenu(new InventoryManagement("inventory.txt")).run();
    }

}
