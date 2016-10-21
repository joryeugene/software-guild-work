package com.swcguild.jspsitelab;

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
                result = convertLength(startingUnit, endingUnit, value);
                break;
            case "temperature":
                result = convertTemperature(startingUnit, endingUnit, value);
                break;
        }
        
        model.addAttribute("result", result);
        
        return "UnitConverter02";
    }
    
    private double convertLength(String startingUnit, String endingUnit, double value) {
        double base = 0.0;
        double result = 0.0;
        
        switch (startingUnit) {
            case "foot": base = value;
                break;
            case "yard": base = value * 3;
                break;
        }
        
        switch(endingUnit) {
            case "foot": result = base;
                break;
            case "yard": result = base / 3;
                break;
        }

        return result;        
    }
    
    private double convertTemperature(String startingUnit, String endingUnit, double value) {
        double base = 0.0;
        double result = 0.0;
        
        switch (startingUnit) {
            case "celsius": base = value;
                break;
            case "farenheit": base = (value - 32) / 1.8;
                break;
        }
        
        switch(endingUnit) {
            case "celsius": result = base;
                break;
            case "farenheit": result = base * 1.8 + 32;
                break;
        }

        return result;        
    }

}
