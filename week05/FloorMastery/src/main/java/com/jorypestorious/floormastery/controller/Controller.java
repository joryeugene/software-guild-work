package com.jorypestorious.floormastery.controller;

import com.jorypestorious.floormastery.dao.OrderDAO;
import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import com.jorypestorious.floormastery.ui.ConsoleIO;
import com.jorypestorious.floormastery.ui.UI;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    
    OrderDAO dao;
    ConsoleIO io;
    UI ui;
    
    public Controller(OrderDAO dao) {
        this.dao = dao;
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        
        boolean keepRunning = true;
        
        String menuPrompt = "\n       SWC Corp Flooring       \n" +
                          "===============================\n" +
                          "1. Display Order(s) by Date    \n" +
                          "2. Add Order for Current Date  \n" +
                          "3. Add Order for Past Date     \n" +
                          "4. Edit an Order               \n" +
                          "5. Remove an Order             \n" +
                          "6. Exit                      \n\n" +
                          "> Selection: ";
        
        while (keepRunning) {
            
            int selection = io.promptInt(menuPrompt, 1, 6);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    displayOrders( io.promptDate("Date of Order (YYYY-MM-DD): ") );
                    break;
                case 2:
                    addOrder(LocalDate.now());
                    break;
                case 3:
                    addOrder( io.promptDate("Date of Order (YYYY-MM-DD): ", LocalDate.MIN, LocalDate.now()) );
                    break;
                case 4:
                    editOrder();
                    break;
                case 5:
                    removeOrder();
                    break;
                case 6:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        io.display("Goodbye.");
        
    }
    
    private boolean displayOrders(LocalDate date) {
        List<Order> orders = dao.getOrders(date);
        if (orders == null) {
            io.display("! Order Not Found for this Date");
            return false;
        } else {
            ui.displayOrders(orders);
            return true;
        }
    }
    
    private void addOrder(LocalDate date) {
        dao.getOrders(date); 
        
        String customer = io.promptString("Customer Name: ");
        TaxRate taxRate = dao.getTaxRate(getStateCode());
        Product productType = dao.getProduct(getProductType());
        double area = io.promptDouble("Area of Material (ft²): ", 0.1, 100000);
        
        Order newOrder = new Order(customer, taxRate, productType, area);
        
        ui.displayOrder(newOrder);
        
        String commitInquiry = io.promptString("\nAdd this Order (y/n)? ");
        
        if (commitInquiry.equalsIgnoreCase("y")) {
            dao.addOrder(date, newOrder);
            io.display("* Order Successfully Added");
            
        } else {
            io.display("! Order Not Added");
        }
        
    }
    
    private String getStateCode() {
        List<String> stateCodes = dao.getStateCodes();
        
        String prompt = "State Code (";

        if (stateCodes.size() == 1) {
            prompt += stateCodes.get(0);
        } else {
            for (int i = 0; i < stateCodes.size(); i++) {
                if (i == stateCodes.size()-1) prompt += "or " + stateCodes.get(i) + "): ";
                else prompt += stateCodes.get(i) + ", ";
            }
        }
        
        String stateCodeInput = "";
        boolean invalidStateCode = true;
        
        do {
            if (invalidStateCode) stateCodeInput = io.promptString(prompt).toUpperCase();
            
            for (String stateCode : stateCodes) {
                if (stateCode.equalsIgnoreCase(stateCodeInput)) invalidStateCode = false;
            }
            
        } while (invalidStateCode);
        
        return stateCodeInput;
    }
    
    private String getProductType() {
        List<String> productTypes = dao.getProductTypes();
        
        String prompt = "Product Type (";

        if (productTypes.size() == 1) {
            prompt += productTypes.get(0);
        } else {
            for (int i = 0; i < productTypes.size(); i++) {
                if (i == productTypes.size()-1) prompt += "or " + productTypes.get(i) + "): ";
                else prompt += productTypes.get(i) + ", ";
            }
        }
        
        String productTypeInput = "";
        boolean invalidProductType = true;
        
        do {
            if (invalidProductType) productTypeInput = io.promptString(prompt).toUpperCase();
            
            for (String productType : productTypes) {
                if (productType.equalsIgnoreCase(productTypeInput)) invalidProductType = false;
            }
            
        } while (invalidProductType);
        
        return productTypeInput;
    }
    
    private void editOrder() {
        
    }
    
    private void removeOrder() {
        LocalDate date = io.promptDate("Date of Order (YYYY-MM-DD): ", LocalDate.MIN, LocalDate.now());
        
        if (displayOrders(date)) {
            int orderNumber = io.promptInt("\nOrder# to Remove (0 to Cancel): ", 0, Order.getCurrentOrderNumber()-1);
            
            if (dao.removeOrder(date, orderNumber)) {
                io.display("* Order Successfully Removed");
            } else {
                io.display("! Order Not Found");
            }
        }        
    }

}
