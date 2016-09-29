package com.jorypestorious.vendingmachine.dao;

import java.util.Map;

public interface DAO {
    
    void save();
    
    Map getInventory();
    
    int getItemCount(String item);
    
    double getItemCost(String item);
    
    double buy(String name, double money);

}
