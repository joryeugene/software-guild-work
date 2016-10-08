package com.jorypestorious.bankaccountmanager;

import com.jorypestorious.bankaccountmanager.controller.ATMController;

public class ATMManager {
    
    public static void main(String[] args) throws InterruptedException {
        new ATMController().run();
    }

}
