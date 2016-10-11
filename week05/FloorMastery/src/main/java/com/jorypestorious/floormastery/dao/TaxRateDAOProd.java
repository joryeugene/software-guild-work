package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.TaxRate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxRateDAOProd implements TaxRateDAO {
    
    public List<TaxRate> run() {
        List<TaxRate> taxRates =  new ArrayList<>();
        
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader("Data/TaxRates.txt")));
            
            while (scanFile.hasNextLine()) {
                String currentLine = scanFile.nextLine();
                
                if (currentLine.length() > 0 ) {
                    String[] taxRateParameters = currentLine.split(",");
                    taxRates.add( new TaxRate(taxRateParameters[0],
                            Double.parseDouble(taxRateParameters[1])) );
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("! Error Reading from /Data/TaxRates.txt");
        }
        return taxRates;
    }
    
    

}
