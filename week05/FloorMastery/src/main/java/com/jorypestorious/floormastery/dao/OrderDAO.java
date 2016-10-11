package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    
    Product getProduct(String productName);
    
    List<String> getProductTypes();
    
    TaxRate getTaxRate(String stateCode);
    
    List<String> getStateCodes();
    
    List<Order> getOrders(LocalDate date);  
    
    void addOrder(LocalDate date, Order newOrder);
    
    boolean removeOrder(LocalDate date, int orderNumber);

}
