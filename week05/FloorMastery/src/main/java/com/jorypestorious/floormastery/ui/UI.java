package com.jorypestorious.floormastery.ui;

import com.jorypestorious.floormastery.dto.Order;
import java.util.List;

public class UI {
    
    public void displayOrders(List<Order> orders) {
        orders.stream().forEach(o -> System.out.println("\n" + o));
    }
    
    public void displayOrder(Order order) {
        System.out.println("\n" + order);
    }
    
}
