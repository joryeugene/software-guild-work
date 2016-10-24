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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderDAOProd implements OrderDAO {
    
    private LocalDate currentOrderListDate;
    private List<Order> currentOrderList;
    
    private final Map<String, List<Order>> orderListsDatabase;
    private final List<String> orderListFileNames;
    private final List<Product> productTypes;
    private final List<TaxRate> stateTaxRates;
    
    public OrderDAOProd(String productFile, String taxFile, String orderListFile) {
        productTypes = new ProductDAOProd().run(productFile);
        stateTaxRates = new TaxRateDAOProd().run(taxFile);
        orderListFileNames = getOrderListFileNames(orderListFile);
        orderListsDatabase = loadFilestoDatabase();
        setCurrentList(LocalDate.now());
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
            orderListFileNames.add(fileName);
            saveOrderListFileNames(orderListFileNames);
        }
        
        currentOrderList = orderList;
    }
    
    private Map<String, List<Order>> loadFilestoDatabase() {
        Map<String, List<Order>> database = new HashMap<>();
        orderListFileNames.stream().forEach(fileName -> database.put(fileName, readFileToList(fileName)));
        return database;
    }
    
    private List<String> getOrderListFileNames(String orderListFile) {
        List<String> fileNames = new ArrayList<>();
        
        try ( Scanner scanFile = new Scanner(new BufferedReader( new FileReader(orderListFile) )) ) {
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    fileNames.add(currentLine.trim());
                }
            }
            
            scanFile.close();
            
        } catch (FileNotFoundException ex) {
            // returns an empty list
        }
        
        return fileNames;
    }
    
    private void saveOrderListFileNames(List<String> orderListFileNames) {
        try ( PrintWriter write = new PrintWriter(new FileWriter("Data/OrderListFileNames.txt")) ) {
            orderListFileNames.stream().forEach(fileName -> write.println(fileName));
            write.flush();
            write.close();
            
        } catch (IOException e) {
            System.out.println("! Error Saving Order Lists Filename Data to File");
        }
    }
    
    private List<Order> readFileToList(String fileName) {
        List<Order> orderList = new ArrayList<>();
        
        try ( Scanner scanFile = new Scanner(new BufferedReader( new FileReader(fileName) )) ) {
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    String[] orderParameters = currentLine.split(",");
                    orderList.add( new Order(Integer.parseInt(orderParameters[0]),
                            orderParameters[1],
                            getTaxRate(orderParameters[2]),
                            getProduct(orderParameters[4]),
                            Double.parseDouble(orderParameters[5]), 
                            fileName) );
                }
            }
            
            scanFile.close();
            
        } catch (FileNotFoundException ex) {
            // returns an empty orderList
        }
        
        return orderList;
    }
    
    @Override
    public void save() {
        String fileName = createFileName(currentOrderListDate);
        orderListsDatabase.put(fileName, currentOrderList); // update in-memory version
        
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
        setCurrentList(date);
        return new ArrayList<>(currentOrderList);
    }
    
    @Override
    public Order getOrder(LocalDate date, int orderNumber) {
        setCurrentList(date);
        Order orderToReturn = currentOrderList.stream()
                .filter(order -> order.getOrderNumber() == orderNumber)
                .findFirst()
                .orElse(null);
        
        return orderToReturn;
    }
    
    @Override
    public int getHighestOrderNumber() {
        int highestNumber = 0;
        
        if (currentOrderList.size() > 0) {
            highestNumber = currentOrderList.stream()
                .max((order1, order2) -> order1.getOrderNumber() > order2.getOrderNumber() ? 1 : -1)
                .get()
                .getOrderNumber();
        }
        
        return highestNumber;
    }
    
    @Override
    public void addOrder(LocalDate date, Order newOrder) {
        setCurrentList(date);
        newOrder.setFileName(createFileName(date));
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
        
        boolean succesfulRemoval = currentOrderList.removeIf(order -> order.getOrderNumber() == orderNumber);
        save(); //remove to allow data to be discarded when not explicitly saving
        
        return succesfulRemoval;
    }
    
    @Override
    public List<Order> getOrdersMatchingStateCode(String stateCode) {
        return orderListsDatabase.values().stream()
                .flatMap(orders -> orders.stream())
                .filter(order -> order.getTaxRate().getStateCode().equalsIgnoreCase(stateCode))
                .collect(Collectors.toList());
    }
    
}
