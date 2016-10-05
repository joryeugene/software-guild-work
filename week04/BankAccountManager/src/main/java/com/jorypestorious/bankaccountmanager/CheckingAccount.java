package com.jorypestorious.bankaccountmanager;

public class CheckingAccount extends Account {
    
    public CheckingAccount() {
        balance = 0;
    }
    
    public CheckingAccount(double startingBalance) {
        balance = startingBalance;
    }
    
    //Allow the checking account to go into negative and apply an overdraft fee of $10. Don't let the user go into
    //overdraft protection over $100. You could also prevent the user from making multiple withdraws if they are
    //already overdrawn. 
    @Override
    public String withdraw(double money) {
        if (money > availableBalance + 100 || availableBalance < 0.0) {
            return "Transaction could not be complete.";
        } else if (money > availableBalance) {
            availableBalance -=  (money + 10.0);
            return "! $10 overdraft charge";
        } else {
            availableBalance -= money;
            return "* Withdrawl successful";
        }
    }

}
