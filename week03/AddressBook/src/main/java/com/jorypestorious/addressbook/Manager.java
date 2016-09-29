package com.jorypestorious.addressbook;

import com.jorypestorious.addressbook.controller.Controller;
import com.jorypestorious.addressbook.dao.DataStorageManagement;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new Controller(new DataStorageManagement("addresses.txt")).run();
    }

}
