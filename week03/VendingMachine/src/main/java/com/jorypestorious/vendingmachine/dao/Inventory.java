package com.jorypestorious.vendingmachine.dao;

import com.jorypestorious.vendingmachine.dto.Item;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    
    private final Map<String, Item> inventory;
    private final DataPersistence dao;
    private final String filename;
    
    public Inventory(String filename) {
        this.filename = filename;
        dao = new DataPersistence();
        inventory = dao.fileToHashMap(filename);
    }
    
    public void save() {
        dao.saveToFile(inventory, filename);
    }
    
    public Map getInventory() {
        return new HashMap<>(inventory);
    }
    
    public int getItemCount(String item) {
        if (inventory.containsKey(item)) {
            return inventory.get(item).getCount();
        } else {
            return 0;
        }
    }
    
    public double getItemCost(String item) {
        return inventory.get(item).getCost();
    }
    
    public double buy(String name, double money) {
        double cost = inventory.get(name).getCost();
        if (money >= cost && inventory.get(name).getCount() > 0) {
            inventory.get(name).takeOne();
            dao.saveToFile(inventory, filename);
            return money -= cost;
        } else {
            return -1;
        }
    }

}
