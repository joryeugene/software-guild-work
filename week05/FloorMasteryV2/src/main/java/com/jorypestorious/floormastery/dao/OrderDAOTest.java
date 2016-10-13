package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
    
public class OrderDAOTest implements OrderDAO {
    
    private LocalDate currentOrderListDate;
    private List<Order> currentOrderList;
    private final Map<String, List<Order>> orderListsDatabase;
    private final List<Product> productTypes;
    private final List<TaxRate> stateTaxRates;
    
    public OrderDAOTest() {
        productTypes = new ProductDAOProd().run();
        stateTaxRates = new TaxRateDAOProd().run();
        orderListsDatabase = new HashMap<>();
        
        currentOrderList = new ArrayList<>();
        initializeListForTest();
    }
    
    private void initializeListForTest() {
        // Test list
        currentOrderListDate = LocalDate.now();
        currentOrderList.add(new Order(1, "Customer1", getTaxRate("OH"), getProduct("Carpet"), 100));
        currentOrderList.add(new Order(2, "Customer2", getTaxRate("PA"), getProduct("Laminate"), 200));
        currentOrderList.add(new Order(3, "Customer3", getTaxRate("MI"), getProduct("Tile"), 300));
        currentOrderList.add(new Order(4, "Customer4", getTaxRate("IN"), getProduct("Wood"), 400));
        save();
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
    
    private String createFileName(LocalDate date) {
        String fileName = "Data/Orders_";
        
        if (date.getMonthValue() < 10) fileName += "0" + date.getMonthValue();
        else  fileName += date.getMonthValue();
        
        if (date.getDayOfMonth() < 10) fileName += "0" + date.getDayOfMonth();
        else  fileName += date.getDayOfMonth();
        
        fileName += date.getYear() + ".txt";
        
        return fileName;
    }
    
    private void setCurrentList(LocalDate date) {
        currentOrderListDate = date;
        String fileName = createFileName(date);
        
        List<Order> orderList = new ArrayList<>();
        
        if (orderListsDatabase.containsKey(fileName)) {
            orderList = orderListsDatabase.get(fileName);
        } else {
            orderListsDatabase.put(fileName, orderList);
        }
        
        currentOrderList = orderList;
    }
        
    @Override
    public void save() {
        orderListsDatabase.put(createFileName(currentOrderListDate), currentOrderList);
    }
    
    @Override
    public List<Order> getOrders(LocalDate date) {
        setCurrentList(date);
        return new ArrayList<>(currentOrderList);
    }
    
    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        setCurrentList(date);
        Order orderToReturn = null;
        
        for (Order order : currentOrderList) {
            if (order.getOrderNumber() == orderNumber) {
                orderToReturn = order;
            }
        }
        
        return orderToReturn;
    }
    
    @Override
    public int getHighestOrderNumber() {
        int highestNumber = 0;
        if (currentOrderList.size() > 0) highestNumber = currentOrderList.stream()
                .max((order1, order2) -> order1.getOrderNumber() > order2.getOrderNumber() ? 1 : -1)
                .get()
                .getOrderNumber();
        return highestNumber;
    }
    
    @Override
    public void addOrder(LocalDate date, Order newOrder) {
        setCurrentList(date);
        currentOrderList.add(newOrder);
        save(); //remove to allow data to be discarded when not explicitly saving
    }
    
    @Override
    public void editOrder(Order oldOrder, Order updatedOrder) {
        currentOrderList.set(currentOrderList.indexOf(oldOrder), updatedOrder);
        save(); //remove to allow data to be discarded when not explicitly saving
    }
    
    @Override
    public boolean removeOrder(LocalDate date, int orderNumber) {
        setCurrentList(date);
        
        for (Order order : currentOrderList) {
            if (order.getOrderNumber() == orderNumber) {
                currentOrderList.remove(order);
                save(); //remove to allow data to be discarded when not explicitly saving
                return true;
            }
        }
        
        return false;
    }
    
}
