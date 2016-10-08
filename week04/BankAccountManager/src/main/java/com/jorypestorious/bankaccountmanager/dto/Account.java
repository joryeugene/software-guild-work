package com.jorypestorious.bankaccountmanager.dto;

import java.text.DecimalFormat;

public abstract class Account {
    
    protected double balance = 0.0;
    protected double availableBalance = 0.0;
    protected double pendingBalance = 0.0;
    protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");
    
    public String deposit(double money) {
        if (money > 10000) {
            pendingBalance += money;
        } else {
            availableBalance += money;
        }
        
        return getBalance(); // return new balance
    }
    
    public String withdraw(double money) {
        String greaterThanBalanceMsg = "Requested amount was greater than available balance.\n";
        if (availableBalance > 0) greaterThanBalanceMsg += "The remaining available balance of " + df.format(availableBalance) + " was withdrawn.";
        availableBalance = (money > availableBalance) ? 0 : availableBalance - money;
        return (money > availableBalance) ? greaterThanBalanceMsg : df.format(money) + " was withdrawn."; // return how much money was actually withdrawn from the available balance
    }    

    public String getBalance() {
        balance = availableBalance + pendingBalance;
        return df.format(balance);
    }
    
    public String getAvailableBalance() {
        return df.format(availableBalance);
    }
    
    public String getPendingBalance() {
        return df.format(pendingBalance);
    }
    
    

}
