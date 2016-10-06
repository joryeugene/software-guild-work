package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryManagement implements DAO {
    
    private final Map<Integer, Product> inventory;
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
    public Product getProduct(int id) {
        return inventory.get(id);
    }
    
    @Override
    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        save();
    }
    
    @Override
    public void updateProduct(int id, Product product) {
        inventory.replace(id, product);
        save();
    }
        
    @Override
    public void save() {
        dao.saveToFile(inventory, filename);
    }
    
    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = inventory.values().stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
        
        return products;
        
    }
    
    @Override
    public List<String> getCategories() {
        List<String> categories = inventory.values().stream()
                .map(product -> product.getCategory())
                .distinct()
                .collect(Collectors.toList());
        
        return categories;
    }
    
    @Override
    public List<Product> getProductsByBrand(String brand) {
        List<Product> products = inventory.values().stream()
                .filter(product -> product.getBrand().equals(brand))
                .collect(Collectors.toList());
        
        return products;
        
    }
    
    @Override
    public List<String> getBrands() {
        List<String> brands = inventory.values().stream()
                .map(product -> product.getBrand())
                .distinct()
                .collect(Collectors.toList());
        
        return brands;
    }
    
    @Override
    public List<Product> getProductsToRestock(int quantity) {
        List<Product> products = inventory.values().stream()
                .filter(product -> product.getQuantity() < quantity)
                .collect(Collectors.toList());
        
        return products;
    }

}
