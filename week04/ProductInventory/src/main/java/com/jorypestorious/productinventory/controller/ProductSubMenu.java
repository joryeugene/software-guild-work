package com.jorypestorious.productinventory.controller;

import com.jorypestorious.productinventory.dao.DAO;
import com.jorypestorious.productinventory.dto.Product;
import com.jorypestorious.productinventory.ui.ConsoleIO;
import com.jorypestorious.productinventory.ui.UI;

public class ProductSubMenu {
    
    private final UI ui;
    private final DAO dao;
    private final ConsoleIO io;
    
    private Product product;
    private int id;
    
    public ProductSubMenu(DAO dao, UI ui, ConsoleIO io) {
        this.dao = dao;
        this.ui = ui;
        this.io = io;
    }
        
    public void run() throws InterruptedException {
        id = io.promptInt("Product ID: ", 1, Product.getCurrentProductId());
        
        product = dao.getProduct(id);
        
        if (product == null) {
            io.display("! Product Not Found");
        } else {            
            displayProductDetails();
            
            String menuPrompt = "\n1. View Product Details\n" +
                                  "2. Add Quantity\n" +
                                  "3. Remove Quantity\n" +
                                  "4. Change Brand Name\n" +
                                  "5. Change Product Name\n" +
                                  "6. Change Price\n" +
                                  "7. Delete Product from System\n" +
                                  "8. Back to Main Menu\n" +
                                  "> Selection: ";
        
            boolean keepRunning = true;
            
            while (keepRunning) {
                
                Thread.sleep(1000);
                
                int selection = io.promptInt(menuPrompt, 1, 8);
                io.display(""); // line break
                
                switch (selection) {
                    case 1:
                        displayProductDetails();
                        break;
                    case 2:
                        addQuantity();
                        break;
                    case 3:
                        removeQuantity();
                        break;
                    case 4:
                        changeBrandName();
                        break;
                    case 5:
                        changeProductName();
                        break;
                    case 6:
                        changePrice();
                        break;
                    case 7:
                        if (deleteProduct()) keepRunning = false;
                    case 8:
                        keepRunning = false;
                }
                
                Thread.sleep(500);
            }
        }
    }
    
    private void displayProductDetails() {
        io.display("\n" + product);
        io.display("\n>>>>>>> Total Product Valuation: " + dao.getProductStockValuation(id) + " <<<<<<<");
    }
    
    private void addQuantity() {
        int quantityToAdd = io.promptInt("Quantity to Add: ", 0, 10000);
        product.addQuantity(quantityToAdd);
        dao.updateProduct(id, product);
        io.display("\n* Successfully Added " + quantityToAdd + 
                " to Quantity (New Total: " + product.getQuantity() + ")");
    }
    
    private void removeQuantity() {
        int quantityToRemove = io.promptInt("Quantity to Remove: ", 0, 10000);
        product.removeQuantity(quantityToRemove);
        dao.updateProduct(id, product);
        io.display("\n* Successfully Removed " + quantityToRemove + 
                " from Quantity (New Total: " + product.getQuantity() + ")");
    }
    
    private void changeBrandName() {
        String oldBrand = product.getBrand();
        String newBrand = io.promptString("New Brand Name: ");
        product.setBrand(newBrand);
        dao.updateProduct(id, product);
        io.display("\n* Successfully Change Brand from " + oldBrand + " to " + newBrand);
    }
    
    private void changeProductName() {
        String oldName = product.getName();
        String newName = io.promptString("New Product Name: ");
        product.setName(newName);
        dao.updateProduct(id, product);
        io.display("\n* Successfully Change Product Name from " + oldName + " to " + newName);
    }
    
    private void changePrice() {
        String oldPrice = product.getPriceFormatted();
        double newPrice = io.promptDouble("New Price: ", 0, 10000);
        product.setPrice(newPrice);
        dao.updateProduct(id, product);
        io.display("\n* Successfully Change Price from " + oldPrice + " to " + product.getPriceFormatted());
    }
    
    private boolean deleteProduct() {
        if (io.promptString("Enter 'delete' to continue with this action: ").equalsIgnoreCase("delete")) {
            dao.deleteProduct(id);
            io.display("* Product Successfully Removed");
            return true;
        } else {
            io.display("! Action Canceled");
            return false;
        }
    }

}
