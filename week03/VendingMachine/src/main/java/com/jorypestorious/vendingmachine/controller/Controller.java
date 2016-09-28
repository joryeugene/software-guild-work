package com.jorypestorious.vendingmachine.controller;

import com.jorypestorious.vendingmachine.dao.Inventory;
import com.jorypestorious.vendingmachine.ui.ConsoleIO;
import com.jorypestorious.vendingmachine.ui.UI;
import java.text.DecimalFormat;

public class Controller {
    
    private final DecimalFormat df;
    private final Inventory dao;
    private final ConsoleIO io;
    private final UI ui;
    private double money;
    
    public Controller(Inventory inv) {
        dao = inv;
        ui = new UI();
        io = new ConsoleIO();
        df = new DecimalFormat("$#0.00");
    }
    
    public void run() throws InterruptedException {
                
        ui.displayInventory(dao.getInventory());
        
        money = io.promptDouble("> Insert Money: ", 0.01, 100);
        io.display("\n>>>> You have: " + df.format(money) + " <<<<");
        
        Thread.sleep(1000);
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            
            String menuPrompt = "\n1. Buy an Item\n" +
                                  "2. See Available Items\n" +
                                  "3. Insert More Money\n" +
                                  "4. Take Any Change and Exit\n\n" +
                                  "> Selection: ";
            
                              //  "4. INVENTORY MANAGEMENT (Password Protected)\n" +
  
            int selection = io.promptInt(menuPrompt, 1, 4);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    buyItem();
                    break;
                case 2:
                    ui.displayInventory(dao.getInventory());
                    break;
                case 3:
                    money += io.promptDouble("> Insert Money: ", 0.01, 100);
                    io.display("\n>>>> You now have: " + df.format(money) + " <<<<"); 
                    break;
                case 4:
                    keepRunning = false;
            }
            
            Thread.sleep(1300);                       
        }
        
        io.display(giveChange());
        dao.save();
    }
    
    private void buyItem() {
        String item = io.promptString("> Item Name: ");
        if (dao.getItemCount(item) > 0) {
            if (dao.getItemCost(item) <= money) {
                money = dao.buy(item, money);
                io.display("* You successfully bought " + item);
                io.display("\n>>>> You now have: " + df.format(money) + " <<<<"); 
                dao.save();
            } else {
                io.display("! Insufficient Funds");
                io.display("\n>>>> You have: " + df.format(money) + " <<<<"); 
            }
        } else {
            io.display("! Item Not Found");
        }
    }
    
    private String giveChange() {
        if (money < 0.01) return "No change to return";
        else {
            int dollars = 0;
            int quarters = 0;
            int dimes = 0;
            int nickles = 0;
            int pennies = 0;
            int and = -1;
            String result = "* Returning ";
            
            if (money >= 1.0) {
                dollars = (int)money;
                money -= dollars;
            }
            
            if (money < 0.01) and = 0;
            
            if (money >= 0.25) {
                quarters = (int)(money/0.25);
                money -= quarters * 0.25;
            }
            
            if (money < 0.01 && and == -1) and = 1;
            
            if (money >= 0.1) {
                dimes = (int)(money/0.1);
                money -= dimes * 0.1;
            }
            
            if (money < 0.01 && and == -1) and = 2;
            
            if (money >= 0.05) {
                nickles = (int)(money/0.05);
                money -= nickles * 0.05;
            }
            
            if (money < 0.01 && and == -1) and = 3;
            
            if (money >= 0.01) {
                pennies = (int)(money/0.01);
                money -= pennies * 0.01;
            }
            
            if (money < 0.01 && and == -1) and = 4;
            
            if (dollars > 0) {
                if (dollars == 1) {
                    result += "1 dollar ";
                } else {
                    result += dollars + " dollars ";
                }
            }
            
            if (and == 1) result += "and ";
            
            if (quarters > 0) {
                if (quarters == 1) {
                    result += "1 quarter ";
                } else {
                    result += quarters + " quarters ";
                }
            }
            
            if (and == 2) result += "and ";
            
            if (dimes > 0) {
                if (dimes == 1) {
                    result += "1 dime ";
                } else {
                    result += dimes + " dimes ";
                }
            }
            
            if (and == 3) result += "and ";
            
            if (nickles > 0) {
                if (nickles == 1) {
                    result += "1 nickle ";
                } else {
                    result += nickles + " nickles ";
                }
            }
            
            if (and == 4) result += "and ";
            
            if (pennies > 0) {
                if (pennies == 1) {
                    result += "1 penny ";
                } else {
                    result += pennies + " pennies ";
                }
            }
            
            result += "in change";
            
            return result;
        }

    }

}
