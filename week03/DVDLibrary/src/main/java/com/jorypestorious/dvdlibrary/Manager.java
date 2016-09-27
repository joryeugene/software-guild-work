package com.jorypestorious.dvdlibrary;

import com.jorypestorious.dvdlibrary.controller.Controller;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        String filename = "DVDLibrary.txt";
        Controller c = new Controller(filename);
        c.run();
    }
    
}
