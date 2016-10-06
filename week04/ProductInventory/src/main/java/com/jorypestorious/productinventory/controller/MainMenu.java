package com.jorypestorious.productinventory.controller;

import com.jorypestorious.productinventory.dao.DAO;
import com.jorypestorious.productinventory.dto.Ball;
import com.jorypestorious.productinventory.dto.Product;
import com.jorypestorious.productinventory.dto.Racquet;
import com.jorypestorious.productinventory.dto.Shoe;
import com.jorypestorious.productinventory.ui.ConsoleIO;
import com.jorypestorious.productinventory.ui.UI;
import java.util.List;

public class MainMenu {
    
    private final UI ui;
    private final DAO dao;
    private final ConsoleIO io;
    private final ProductSubMenu subMenu;
    
    public MainMenu(DAO dao) {
        this.dao = dao;
        ui = new UI();
        io = new ConsoleIO();
        subMenu = new ProductSubMenu(dao, ui, io);
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n       STORE INVENTORY\n" +
                              "=============================\n" +
                              "1. View Entire Inventory\n" +
                              "2. View Products by Category\n" +
                              "3. View Products by Brand Name\n" +
                              "4. View/Edit Product by ID\n" +
                              "5. Add Product\n" +
                              "6. Find Products to Restock\n" +
                              "7. Exit the Program\n\n" +
                              "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 1, 7);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    ui.displayProducts(dao.getInventory());
                    break;
                case 2:
                    displayProductsByCategory();
                    break;
                case 3:
                    displayProductsByBrand();
                    break;
                case 4:
                    subMenu.run();
                    break;
                case 5:
                    addProduct();
                    break;
                case 6:
                    int quantity = io.promptInt("Show Products Below Quantity of: ", 1, 1000);
                    ui.displayProducts(dao.getProductsToRestock(quantity));
                    break;
                case 7:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
        io.display("Goodbye.");
    }
    
    private void displayProductsByCategory() {
        List<String> productCategories = dao.getCategories();
        
        String prompt = "";
        
        for (int i = 0; i < productCategories.size(); i++) {
            if (productCategories.get(i).equals("Product")) productCategories.set(i, "General");
            if (i == productCategories.size()-1) prompt += "or " + productCategories.get(i) + "? ";
            else prompt += productCategories.get(i) + ", ";
        }
        
        String selection = io.promptString(prompt);
        io.display(""); // line break
        boolean knownCategory = false;
                
        for (String category : productCategories) {
            if (selection.equals(category)) knownCategory = true;
        }
        
        if (selection.equals("General")) selection = "Product";
                
        if (knownCategory) ui.displayProducts(dao.getProductsByCategory(selection));
        else io.display("! Category Not Found");
    }
    
    private void displayProductsByBrand() {
        List<String> brands = dao.getBrands();
        
        String prompt = "";
        
        for (int i = 0; i < brands.size(); i++) {
            if (i == brands.size()-1) prompt += "or " + brands.get(i) + "? ";
            else prompt += brands.get(i) + ", ";
        }
        
        String selection = io.promptString(prompt);
        io.display(""); // line break
        boolean knownBrand = false;
                
        for (String brand : brands) {
            if (selection.equals(brand)) knownBrand = true;
        }
                        
        if (knownBrand) ui.displayProducts(dao.getProductsByBrand(selection));
        else io.display("! Brand Not Found");
    }
    
    private void addProduct() { // service layer
        List<String> productCategories = dao.getCategories();
        
        String prompt = "";
        
        for (int i = 0; i < productCategories.size(); i++) {
            if (productCategories.get(i).equals("Product")) productCategories.set(i, "General");
            if (i == productCategories.size()-1) prompt += "or " + productCategories.get(i) + "? ";
            else prompt += productCategories.get(i) + ", ";
        }
        
        String selection = io.promptString(prompt);
        io.display(""); // line break
        boolean knownCategory = false;
                
        for (String category : productCategories) {
            if (selection.equals(category)) knownCategory = true;
        }
        
        if (selection.equals("General")) selection = "Product";
                
        if (!knownCategory) io.display("! Category Not Found");
        else {
            switch (selection) {
                case "Product":
                    dao.addProduct(createNewProduct());
                    break;
                case "Racquet":
                    dao.addProduct(createNewRacquet());
                    break;
                case "Ball":
                    dao.addProduct(createNewBall());
                    break;
                case "Shoe":
                    dao.addProduct(createNewShoe());
            }
            
            io.display("\n* Product Added Successfully");
        }
         
    }
    
    private Product createNewProduct() {
        String brand = io.promptString("Brand Name: ");
        String name = io.promptString("Product Name: ");
        double price = io.promptDouble("Price: $", 0, 10000);
        int quantity = io.promptInt("Quantity: ", 0, 10000);
        
        return new Product(brand, name, price, quantity);
    }
    
    private Product createNewRacquet() {
        String brand = io.promptString("Brand Name: ");
        String name = io.promptString("Product Name: ");
        String weight = io.promptString("Weight: ");
        String color = io.promptString("Color: ");
        double price = io.promptDouble("Price: $", 0, 10000);
        int quantity = io.promptInt("Quantity: ", 0, 10000);
        
        return new Racquet(brand, name, weight, color, price, quantity);
    }
    
    private Product createNewBall() {
        String brand = io.promptString("Brand Name: ");
        String name = io.promptString("Product Name: ");
        String dots = io.promptString("Dots: ");
        double price = io.promptDouble("Price: $", 0, 10000);
        int quantity = io.promptInt("Quantity: ", 0, 10000);
        
        return new Ball(brand, name, dots, price, quantity);
    }
    
    private Product createNewShoe() {
        String brand = io.promptString("Brand Name: ");
        String name = io.promptString("Product Name: ");
        String size = io.promptString("Size: ");
        String color = io.promptString("Color: ");
        double price = io.promptDouble("Price: $", 0, 10000);
        int quantity = io.promptInt("Quantity: ", 0, 10000);
        
        return new Shoe(brand, name, size, color, price, quantity);
    }

}
