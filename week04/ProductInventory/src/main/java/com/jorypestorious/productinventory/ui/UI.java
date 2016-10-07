package com.jorypestorious.productinventory.ui;

import com.jorypestorious.productinventory.dto.Product;
import java.util.List;
import java.util.Map;

public class UI {
    
    public void displayProducts(Map<Integer, Product> inv) {
        inv.values().stream().forEach((product) -> {System.out.println(product);});
        if (inv.size() < 1) System.out.println("! No Products Found");
    }
    
    public void displayProducts(List<Product> inv) {
        inv.stream().forEach((product) -> {System.out.println(product);});
        if (inv.size() < 1) System.out.println("! No Products Found");
    }
    

}
