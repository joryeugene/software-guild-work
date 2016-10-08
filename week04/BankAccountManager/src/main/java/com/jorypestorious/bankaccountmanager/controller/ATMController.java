package com.jorypestorious.bankaccountmanager.controller;

import com.jorypestorious.bankaccountmanager.dto.Account;
import com.jorypestorious.bankaccountmanager.dto.CheckingAccount;
import com.jorypestorious.bankaccountmanager.ui.ConsoleIO;
import com.jorypestorious.bankaccountmanager.dto.SavingsAccount;

public class ATMController {
    
    private final ConsoleIO io = new ConsoleIO();
    private final CheckingAccount checking = new CheckingAccount();
    private final SavingsAccount savings = new SavingsAccount();

    public void run() throws InterruptedException {
        
        boolean incorrectPin = true;
        
        do {
            int pinInput = io.promptInt("PIN Number:\n> ", 0, 9999);
            int superSecretPIN = 1234;
            
            if (pinInput == superSecretPIN) {
                io.display("* Correct PIN");
                incorrectPin = false;
            } else {
                io.display("! Incorrect Pin");
            }
            
        } while (incorrectPin);
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            Thread.sleep(1000);
            int menuSelection = io.promptInt("\n1. Checking Account\n" + 
                                             "2. Savings Account\n" + 
                                             "3. Exit\n" +
                                             "> ", 1, 3);
            
            switch (menuSelection) {
                case 1:
                    showAccountMenu(checking);
                    break;
                case 2:
                    showAccountMenu(savings);
                    break;
                case 3:
                    keepRunning = false;
            }
        }
        
        io.display("Goodbye.");
    }
    
    private void showAccountMenu(Account account) throws InterruptedException {
        boolean keepRunning = true;
        boolean largeDeposit = false;
        
        while (keepRunning) {
            Thread.sleep(1000);
            int menuSelection = io.promptInt("\n1. Balance\n" + 
                                             "2. Deposit\n" + 
                                             "3. Withdraw\n" + 
                                             "4. Main Menu\n" +
                                             "> ", 1, 4);
            
            switch (menuSelection) {
                case 1:
                    showBalance(account);
                    break;
                case 2:
                    double depositAmount = io.promptDouble("> Deposit Amount: ", 0.01, 5000000);
                    io.display("* Your total balance is now " + account.deposit(depositAmount));
                    if(depositAmount > 10000) handleLargeDeposit(account);
                    break;
                case 3:
                    double withdrawAmount = io.promptDouble("> Withdraw Amount: ", 0.01, 5000000);
                    io.display(account.withdraw(withdrawAmount));
                    showBalance(account);
                    break;
                case 4:
                    keepRunning = false;
            }
        }
        
    }
    
    private void handleLargeDeposit(Account account){
        io.display("\nDeposits greater than $10,000 must be cleared by a bank manager before becoming available for withdrawl.");
        showBalance(account);
    }
    
    private void showBalance(Account account) {
        io.display("\n<< Total Balance >>\t" + account.getBalance() +
                   "\n<< Available Balance >>\t" + account.getAvailableBalance() +
                   "\n<< Pending Balance >>\t" + account.getPendingBalance());
    }
    
}
