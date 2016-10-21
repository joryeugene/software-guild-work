package com.swcguild.jspsitelab;

import com.swcguild.jspsitelab.dto.UnitConversion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping({"/apps"})
public class UnitConverterController {
    
    @RequestMapping(value="unitconverter", method=RequestMethod.GET)
    public String displayUnitConverter(HttpServletRequest req, Model model) {
        return "UnitConverter01";
    }
    
    @RequestMapping(value="unitconverterresults", method=RequestMethod.POST)
    public String displayUnitConverterResults(HttpServletRequest req, Model model) { 
        
        String converter = req.getParameter("converter");
        String startingUnit = req.getParameter("startingUnit");
        String endingUnit = req.getParameter("endingUnit");
        double value = Integer.parseInt(req.getParameter("value"));
        double result = -1.0;
        
        switch (converter) {
            case "length":
                result = convertLength(value, startingUnit, endingUnit);
                break;
            case "temperature":
                result = convertTemperature(value, startingUnit, endingUnit);
                break;
        }
        
        UnitConversion conversionResult = new UnitConversion(value, startingUnit, endingUnit, result);
        
        model.addAttribute("result", conversionResult);
        
        return "UnitConverter02";
    }
    
    private double convertLength(double value, String startingUnit, String endingUnit) {
        double base = 0.0;
        double result = 0.0;
        
        switch (startingUnit) {
            case "foot": base = value;
                break;
            case "yard": base = value * 3;
                break;
            case "mile": base = value * 5280;
                break;
        }
        
        switch(endingUnit) {
            case "foot": result = base;
                break;
            case "yard": result = base / 3;
                break;
            case "mile": result = base / 5280;
                break;
        }

        return result;        
    }
    
    private double convertTemperature(double value, String startingUnit, String endingUnit) {
        double base = 0.0;
        double result = 0.0;
        
        switch (startingUnit) {
            case "celsius": base = value;
                break;
            case "farenheit": base = (value - 32) / 1.8;
                break;
            case "kelvin": base = value - 273.15;
                break;
        }
        
        switch(endingUnit) {
            case "celsius": result = base;
                break;
            case "farenheit": result = base * 1.8 + 32;
                break;
            case "kelvin": result = base + 273.15;
                break;
        }

        return result;        
    }

}
