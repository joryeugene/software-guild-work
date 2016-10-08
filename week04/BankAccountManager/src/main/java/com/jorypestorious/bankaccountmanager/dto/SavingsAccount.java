package com.jorypestorious.bankaccountmanager.dto;

import com.jorypestorious.bankaccountmanager.dto.Account;

public class SavingsAccount extends Account {
    
    public SavingsAccount() {
        balance = 0;
    }
    
    public SavingsAccount(double startingBalance) {
        balance = startingBalance;
    }

}
