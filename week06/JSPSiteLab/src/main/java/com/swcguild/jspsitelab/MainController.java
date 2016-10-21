package com.swcguild.jspsitelab;

import com.swcguild.jspsitelab.dto.Check;
import com.swcguild.jspsitelab.dto.FactorizorReport;
import com.swcguild.jspsitelab.dto.FlooringReport;
import com.swcguild.jspsitelab.dto.InterestReport;
import com.swcguild.jspsitelab.dto.Lucky7Report;
import com.swcguild.jspsitelab.dto.YearlyInterestReport;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/apps"})
public class MainController {
    
    @RequestMapping(value="luckysevens", method=RequestMethod.GET)
    public String displayLuckySevens(HttpServletRequest req, Model model) {
        return "Lucky7s01";
    }
    
    @RequestMapping(value="luckysevensresults", method=RequestMethod.POST)
    public String displayLuckySevensResults(HttpServletRequest req, Model model) {
        
        int initialValue = Integer.parseInt(req.getParameter("initialValue"));
        
        
        Lucky7Report lucky = new Lucky7Report(initialValue);
        
        Random r = new Random();
        int currentMoney = lucky.getInitialValue();
        lucky.setMaxValue(currentMoney);
        
        while (currentMoney > 0) {
            lucky.incrementNumOfTurns();
            if (1 + r.nextInt(6) == 1 + r.nextInt(6)) {
                currentMoney +=  4;
                if (lucky.getMaxValue() < currentMoney) {
                    lucky.setMaxValue(currentMoney);
                    lucky.setMaxTurn(lucky.getTotalTurns());
                }
                
            } else {
                currentMoney--;
            }
        }
        
        model.addAttribute("lucky", lucky);
        
        return "Lucky7s02";
    }
    
    @RequestMapping(value="factorizor", method=RequestMethod.GET)
    public String displayFactorizor(HttpServletRequest req, Model model) {
        return "Factorizor01";
    }
    
    @RequestMapping(value="factorizorresults", method=RequestMethod.POST)
    public String displayFactorizorResults(HttpServletRequest req, Model model) {
        
        int inputNum = Integer.parseInt(req.getParameter("num")),
                sum = 0;
        
        FactorizorReport num = new FactorizorReport(inputNum);
        
        for (int i = 1; i <= inputNum/2; i++) {
            if (inputNum % i == 0) {
                num.addFactor(i);
                sum += i;
            }
        }
        
        if (inputNum == sum) num.setPerfect(true);
        
        if (inputNum + sum == inputNum + 1) num.setPrime(true);
        
        model.addAttribute("num", num);
        
        return "Factorizor02";
    }
    
    @RequestMapping(value="interestcalculator", method=RequestMethod.GET)
    public String displayInterestCalculator(HttpServletRequest req, Model model) {
        return "InterestCalculator01";
    }
    
    @RequestMapping(value="interestcalculatorresults", method=RequestMethod.POST)
    public String displayInterestCalculatorResults(HttpServletRequest req, Model model) {
        
        double principal = Double.parseDouble(req.getParameter("principal").replaceAll("[$,%]", ""));
        double interestRate = Double.parseDouble(req.getParameter("interestRate").replaceAll("[$,%]", ""));
        int compoundPeriod = Integer.parseInt(req.getParameter("compoundPeriod"));
        int years = Integer.parseInt(req.getParameter("years"));
        
        InterestReport report = new InterestReport(principal, interestRate, compoundPeriod, years);
        
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int targetYear = currentYear + years;
        
        DecimalFormat df = new DecimalFormat("$###,###,##0.00");
        
        List<YearlyInterestReport> annualInterestReports = new ArrayList<>();
        
        while (currentYear < targetYear) {
            YearlyInterestReport yearlyReport = new YearlyInterestReport();
            yearlyReport.setYear(currentYear);
            currentYear++;
            
            yearlyReport.setStartingPrincipal(df.format(principal));
            
            double oldPrincipal = principal;
            
            for (int i = 0; i < compoundPeriod ; i++) {
                principal *= (1 + ((interestRate / compoundPeriod) / 100));
            }
            
            double yearInterest = principal - oldPrincipal;
            yearlyReport.setInterest(df.format(yearInterest));
            
            yearlyReport.setEndingPrincipal(df.format(principal));
            
            annualInterestReports.add(yearlyReport);
        }
        
        report.setAnnualInterestReports(annualInterestReports);
        
        model.addAttribute("report", report);
        
        return "InterestCalculator02";
    }
    
    @RequestMapping(value="flooringcalculator", method=RequestMethod.GET)
    public String displayFlooringCalculator(HttpServletRequest req, Model model) {
        return "FlooringCalculator01";
    }
    
    @RequestMapping(value="flooringcalculatorresults", method=RequestMethod.POST)
    public String displayFlooringCalculatorResults(HttpServletRequest req, Model model) { 
        int width = Integer.parseInt(req.getParameter("width"));
        int length = Integer.parseInt(req.getParameter("length"));
        double materialCostPerSquareFt = Double.parseDouble(req.getParameter("materialCostPerSquareFt"));
        
        int area = width * length;
        double materialCost = area * materialCostPerSquareFt;
        double laborCost = Math.ceil( ((area/20.0) * 60) / 15) * 21.5;  // ($21.5 for every 15 minutes of work / 20 ft an hour)
        
        FlooringReport report = new FlooringReport(width, length, materialCost, laborCost);
        model.addAttribute("report", report);
        
        return "FlooringCalculator02";
    }
    
    @RequestMapping(value="tipcalculator", method=RequestMethod.GET)
    public String displayTipCalculator(HttpServletRequest req, Model model) {
        return "TipCalculator01";
    }
    
    @RequestMapping(value="tipcalculatorresults", method=RequestMethod.POST)
    public String displayTipCalculatorResults(HttpServletRequest req, Model model) { 
        double subtotal = Double.parseDouble(req.getParameter("subtotal"));
        double tipPercentage = Double.parseDouble(req.getParameter("tipPercentage"));
        
        Check check = new Check(subtotal, tipPercentage);
        model.addAttribute("check", check);
        
        return "TipCalculator02";
    }
    
      
}