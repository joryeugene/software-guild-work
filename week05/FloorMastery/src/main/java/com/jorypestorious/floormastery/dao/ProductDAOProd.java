package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAOProd implements ProductDAO {
    
    @Override
    public List<Product> run() {
        
        List<Product> productTypes = new ArrayList<>();
        
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader("Data/ProductTypes.txt")));
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    String[] productParameters = currentLine.split(",");
                    productTypes.add( new Product(productParameters[0],
                            Double.parseDouble(productParameters[1]),
                            Double.parseDouble(productParameters[2])) );
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("! Error Reading from /Data/ProductTypes.txt");
        }
        
        return productTypes;
    }

}
