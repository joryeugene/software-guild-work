package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Product;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement implements DAO {
    
    private Map<Integer, Product> inventory;
    DataPersistence dao;
    String filename;
    
    public InventoryManagement(String filename) {
        this.filename = filename;
        dao = new DataPersistence();
        inventory = dao.fileToInventory(filename);
    }
    
    @Override
    public Map getInventory() {
        return new HashMap<>(inventory);
    }
    
    @Override
    public void save() {
        dao.saveToFile(inventory, filename);
    }

}
