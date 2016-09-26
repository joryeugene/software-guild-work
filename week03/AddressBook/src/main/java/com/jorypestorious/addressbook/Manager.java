package com.jorypestorious.addressbook;

import com.jorypestorious.addressbook.controller.Controller;

public class Manager {
    
    public static void main(String[] args) {
        String filename = "addresses.txt";
        Controller c = new Controller(filename);
        c.run();
    }

}
