package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDAOTest implements OrderDAO {
    
    // private LocalDate currentOrderListDate;
    private final List<Order> currentOrderList;
    private final List<Product> productTypes;
    private final List<TaxRate> stateTaxRates;
    
    public OrderDAOTest() {
        productTypes = new ProductDAOProd().run();
        stateTaxRates = new TaxRateDAOProd().run();
        
        currentOrderList = new ArrayList<>();
        initializeListForTest();
    }
    
    private void initializeListForTest() {
        // Test list
        currentOrderList.add(new Order("Customer1", getTaxRate("OH"), getProduct("Carpet"), 100));
        currentOrderList.add(new Order("Customer2", getTaxRate("PA"), getProduct("Laminate"), 200));
        currentOrderList.add(new Order("Customer3", getTaxRate("MI"), getProduct("Tile"), 300));
        currentOrderList.add(new Order("Customer4", getTaxRate("IN"), getProduct("Wood"), 400));
    }
    
    @Override
    public Product getProduct(String productName) {
        return productTypes.stream()
                .filter(p -> p.getType().equalsIgnoreCase(productName))
                .findFirst()
                .get();
    }
    
    @Override
    public List<String> getProductTypes() {
        return productTypes.stream().map(p -> p.getType()).collect(Collectors.toList());
    }
    
    @Override
    public TaxRate getTaxRate(String stateCode) {
        return stateTaxRates.stream()
                .filter(tax-> tax.getStateCode().equalsIgnoreCase(stateCode))
                .findFirst()
                .get();
    }
    
    @Override
    public List<String> getStateCodes() {
        return stateTaxRates.stream().map(p -> p.getStateCode()).collect(Collectors.toList());
    }
    
    private void readFileToList(LocalDate date) {}
    
    private void save() {}
    
    @Override
    public List<Order> getOrders(LocalDate date) {
        readFileToList(date);
        return new ArrayList<>(currentOrderList);
    }
    
    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        readFileToList(date);
        Order orderToReturn = null;
        
        for (Order order : currentOrderList) {
            if (order.getOrderNumber() == orderNumber) {
                orderToReturn = order;
            }
        }
        
        return orderToReturn;
    }
    
    @Override
    public void addOrder(LocalDate date, Order newOrder) {
        readFileToList(date);
        currentOrderList.add(newOrder);
        save();
    }
    
    @Override
    public void editOrder(Order oldOrder, Order updatedOrder) {
        int index = currentOrderList.indexOf(oldOrder);
        currentOrderList.set(index, updatedOrder);
        save();
    }
    
    @Override
    public boolean removeOrder(LocalDate date, int orderNumber) {
        readFileToList(date);
        
        for (Order order : currentOrderList) {
            if (order.getOrderNumber() == orderNumber) {
                currentOrderList.remove(order);
                save();
                return true;
            }
        }
        
        return false;
    }

}