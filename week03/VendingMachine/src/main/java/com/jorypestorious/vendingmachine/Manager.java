package com.jorypestorious.vendingmachine;

import com.jorypestorious.vendingmachine.controller.Controller;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        String filename = "inventory.txt";
        Controller c = new Controller(filename);
        c.run();
    }

}
