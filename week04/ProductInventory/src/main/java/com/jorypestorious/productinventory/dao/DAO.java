package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Product;
import java.util.List;
import java.util.Map;

public interface DAO {
    
    Map<Integer, Product> getInventory();
    
    Product getProduct(int id);
    
    void addProduct(Product product);
    
    void updateProduct(int id, Product product);

    void save();
    
    List<Product> getProductsByCategory(String category);
    
    List<String> getCategories();
    
    public List<Product> getProductsByBrand(String brand);
    
    public List<String> getBrands();
    
    List<Product> getProductsToRestock(int quantity);

}
