package com.jorypestorious.dvdlibrary;

import com.jorypestorious.dvdlibrary.controller.Controller;
import com.jorypestorious.dvdlibrary.dao.DVDLibrary;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new Controller(new DVDLibrary("DVDLibrary.txt")).run();
    }
    
}
