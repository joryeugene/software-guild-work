package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Product;
import java.util.List;
import java.util.Map;

public interface DAO {
    
    Map<Integer, Product> getInventory();
    
    int getNumberOfProducts();
    
    Product getProduct(int id);
    
    void addProduct(Product product);
    
    void updateProduct(int id, Product product);

    void save();
    
    List<Product> getProductsByCategory(String category);
    
    List<String> getCategories();
    
    List<Product> getProductsByBrand(String brand);
    
    List<String> getBrands();
    
    List<Product> getProductsToRestock(int quantity);
    
    String getProductStockValuation(int id);
    
    String getTotalInventoryValuation();
    
    void deleteProduct(int id);

}
