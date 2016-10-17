package com.jorypestorious.floormastery.controller;

import com.jorypestorious.floormastery.dao.OrderDAO;
import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import com.jorypestorious.floormastery.ui.ConsoleIO;
import com.jorypestorious.floormastery.ui.FlooringIO;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    
    private final OrderDAO dao;
    private final ConsoleIO io;
    private final FlooringIO ui;
    
    public Controller(OrderDAO dao) {
        this.dao = dao;
        io = new ConsoleIO();
        ui = new FlooringIO(io);
    }
    
    public void run() throws InterruptedException {
        
        boolean keepRunning = true;
        
        String menuPrompt = "\n       SWC Corp Flooring       \n" +
                          "===============================\n" +
                          "1. Find Order(s) by Date       \n" +
                          "2. Add Order for Current Date  \n" +
                          "3. Add Order for Past Date     \n" +
                          "4. Edit an Order               \n" +
                          "5. Remove an Order             \n" +
                          "6. Save Current Work           \n" +
                          "7. Exit                      \n\n" +
                          "> Selection: ";
        
        while (keepRunning) {
            
            int selection = io.promptInt(menuPrompt, 1, 7);
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
                    dao.save();
                    io.display("* Work Saved");
                    break;
                case 7:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        io.display("Goodbye.");
    }
    
    private boolean displayOrders(LocalDate date) {
        List<Order> orders = dao.getOrders(date);
        
        if (orders.size() < 1) {
            io.display("! Order Not Found for this Date");
            return false;
        } else {
            ui.displayOrders(orders);
            return true;
        }
    }
    
    private void addOrder(LocalDate date) {
        dao.getOrders(date); // load orderList into dao
        
        String customer = io.promptString("Customer Name: ");
        TaxRate taxRate = getTaxRateFromUser();
        Product productType = getProductTypeFromUser();
        double area = io.promptDouble("Area of Material (ft²): ", 0.1, 100000);
        
        // show new order object to user and ask for confirmation to add
        Order newOrder = new Order(dao.getHighestOrderNumber()+1, customer, taxRate, productType, area);
        ui.displayOrder(newOrder);
        
        String commitInquiry = io.promptString("\nAdd this Order (y/n)? ");
        
        if (commitInquiry.equalsIgnoreCase("y")) {
            dao.addOrder(date, newOrder);
            io.display("* Order Successfully Added");
            
        } else {
            io.display("! Order Not Added");
        }
        
    }
    
    private TaxRate getTaxRateFromUser() {
        return dao.getTaxRate(
                ui.getInputFromList(
                        getDynamicPrompt("State Code", dao.getStateCodes()),
                        dao.getStateCodes() ) );
    }
    
    private Product getProductTypeFromUser() {
        return dao.getProduct(
                ui.getInputFromList(
                        getDynamicPrompt("Product Type", dao.getProductTypes()), 
                        dao.getProductTypes() ) );
    }
            
    private String getDynamicPrompt(String type, List<String> list) {
        String prompt = type + " (";

        if (list.size() == 1) {
            prompt += list.get(0) + ")";
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size()-1) prompt += "or " + list.get(i) + "): ";
                else prompt += list.get(i) + ", ";
            }
        }
        
        return prompt;
    }    

    private void editOrder() {
        LocalDate date = io.promptDate("Date of Order (YYYY-MM-DD): ", LocalDate.MIN, LocalDate.now());
        
        if (displayOrders(date)) {
            int orderNumber = io.promptInt("\nOrder# to Edit (0 to Cancel): ", 0, dao.getHighestOrderNumber());
            Order order = dao.getOrder(date, orderNumber);
            
            if (order == null) {
                io.display("! Order Not Found");
            } else {
                String newName = getNewNameFromUser(order);
                TaxRate newTaxRate = getNewTaxRateFromUser(order);
                Product newProduct = getNewProductFromUser(order);
                double newArea = getNewAreaFromUser(order);
                
                Order updatedOrder = new Order(order.getOrderNumber(), newName, newTaxRate, newProduct, newArea);
                dao.editOrder(order, updatedOrder);
                io.display("\n* Order Successfully Updated\n" + updatedOrder);
            }
        }      
    }
    
    private String getNewNameFromUser(Order order) {
        // get new customer name, empty string to keep the same
        String newName = io.promptString("\nNew Customer Name (" + order.getCustomer() + ") Leave empty to pass: ");
        return (newName.length() > 0) ? newName : order.getCustomer();
    }
    
    private TaxRate getNewTaxRateFromUser(Order order) {
        // get new state code, empty string to keep the same, make sure state code is valid if new one entered
        String newStateCode = ui.getInputFromList(
                "New State Code (" + order.getTaxRate().getStateCode() + ") Leave empty to pass: ",
                getDynamicPrompt("State Code", dao.getStateCodes()),
                dao.getStateCodes() );

        newStateCode = (newStateCode.length() > 0) ? newStateCode : order.getTaxRate().getStateCode();
        
        return dao.getTaxRate(newStateCode);
    }
    
    private Product getNewProductFromUser(Order order) {
        // get new product type, empty string to keep the same, make sure product type is valid if new one entered
        String newProductType = ui.getInputFromList(
                "New Product Type (" + order.getProductType().getType() + ") Leave empty to pass: ", 
                getDynamicPrompt("Product Type", dao.getProductTypes()), 
                dao.getProductTypes() );

        newProductType = (newProductType.length() > 0) ? newProductType : order.getProductType().getType();
        
        return dao.getProduct(newProductType);
    }
    
    private double getNewAreaFromUser(Order order) {
        // get new area, 0 to keep the same
        double newArea = io.promptDouble("New Area (" + order.getArea() + ") 0 to pass: ", 0, 100000);
        return (newArea != 0.0) ? newArea : order.getArea();
    }
    
    private void removeOrder() {
        LocalDate date = io.promptDate("Date of Order (YYYY-MM-DD): ", LocalDate.MIN, LocalDate.now());
        
        if (displayOrders(date)) {
            int orderNumber = io.promptInt("\nOrder# to Remove (0 to Cancel): ", 0, dao.getHighestOrderNumber());
            
            if (dao.removeOrder(date, orderNumber)) {
                io.display("* Order Successfully Removed");
            } else {
                io.display("! Order Not Found");
            }
        }        
    }

}
