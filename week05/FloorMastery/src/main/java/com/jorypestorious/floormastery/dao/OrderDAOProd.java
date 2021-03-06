package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderDAOProd implements OrderDAO {
    
    private LocalDate currentOrderListDate ;
    private List<Order> currentOrderList;
    private final List<Product> productTypes;
    private final List<TaxRate> stateTaxRates;
    
    public OrderDAOProd() {
        productTypes = new ProductDAOProd().run();
        stateTaxRates = new TaxRateDAOProd().run();
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
    
    private void readFileToList(LocalDate date) {
        currentOrderListDate = date;
        Order.resetCurrentOrderNumber();
        List<Order> orderList = new ArrayList<>();
        
        String fileName = createFileName(date);
        
        try ( Scanner scanFile = new Scanner(new BufferedReader( new FileReader(fileName) )) ) {
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    String[] orderParameters = currentLine.split(",");
                    orderList.add( new Order(Integer.parseInt(orderParameters[0]), 
                                             orderParameters[1], 
                                             getTaxRate(orderParameters[2]), 
                                             getProduct(orderParameters[4]), 
                                             Double.parseDouble(orderParameters[5])) );
                }
            }
            
            scanFile.close();
            
        } catch (FileNotFoundException ex) {
            // returns an empty orderList
        }
        
        currentOrderList = orderList;
    }
    
    private void save() {
        String fileName = createFileName(currentOrderListDate);
        
        try ( PrintWriter write = new PrintWriter(new FileWriter(fileName)) ) {
            currentOrderList.stream().forEach(order -> write.println(order.writeToFile()) );
            write.flush();
            write.close();
        
        } catch (IOException e) {
            System.out.println("! Error Saving Data to File");
        }
    }
    
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
