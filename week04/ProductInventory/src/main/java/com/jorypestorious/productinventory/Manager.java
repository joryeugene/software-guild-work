package com.jorypestorious.productinventory;

import com.jorypestorious.productinventory.controller.Controller;
import com.jorypestorious.productinventory.dao.InventoryManagement;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new Controller(new InventoryManagement("inventory.txt")).run();
    }

}
