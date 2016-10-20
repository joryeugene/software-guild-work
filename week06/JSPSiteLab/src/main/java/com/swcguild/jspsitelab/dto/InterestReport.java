package com.swcguild.jspsitelab.dto;

import java.util.List;

public class InterestReport {
    
    private final double principal;
    private final double interestRate;
    private final int compoundPeriod;
    private final int years;
    
    private List<YearlyInterestReport> annualInterestReports;

    public InterestReport(double principal, double interestRate, int compoundPeriod, int years) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.compoundPeriod = compoundPeriod;
        this.years = years;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getCompoundPeriod() {
        return compoundPeriod;
    }

    public int getYears() {
        return years;
    }

    public List<YearlyInterestReport> getAnnualInterestReports() {
        return annualInterestReports;
    }

    public void setAnnualInterestReports(List<YearlyInterestReport> annualInterestReports) {
        this.annualInterestReports = annualInterestReports;
    }    

}
