package com.jorypestorious.vendingmachine;

import com.jorypestorious.vendingmachine.controller.Controller;
import com.jorypestorious.vendingmachine.dao.Inventory;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new Controller(new Inventory("inventory.txt")).run();
    }

}
