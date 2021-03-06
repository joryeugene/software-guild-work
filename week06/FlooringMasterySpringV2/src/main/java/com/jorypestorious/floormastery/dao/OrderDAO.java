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
    
    void save();
    
    List<Order> getOrders(LocalDate date); 
    
    Order getOrder(LocalDate date, int orderNumber);
    
    int getHighestOrderNumber();
    
    void addOrder(LocalDate date, Order newOrder);
    
    void editOrder(Order oldOrder, Order updatedOrder);
    
    boolean removeOrder(LocalDate date, int orderNumber);
    
    List<Order> getOrdersMatchingStateCode(String stateCode); // new
    
}
