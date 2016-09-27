package com.jorypestorious.vendingmachine.dao;

import com.jorypestorious.vendingmachine.dto.Item;
import java.util.HashMap;

public class Inventory {
    
    private final HashMap<String, Item> inventory;
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
    
    public HashMap getInventory() {
        return new HashMap<>(inventory);
    }

}
