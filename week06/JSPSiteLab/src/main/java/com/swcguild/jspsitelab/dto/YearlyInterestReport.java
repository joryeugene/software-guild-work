package com.swcguild.jspsitelab.dto;

public class YearlyInterestReport {
    
    private int year;
    private String startingPrincipal;
    private String interest;
    private String endingPrincipal;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStartingPrincipal() {
        return startingPrincipal;
    }

    public void setStartingPrincipal(String startingPrincipal) {
        this.startingPrincipal = startingPrincipal;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getEndingPrincipal() {
        return endingPrincipal;
    }

    public void setEndingPrincipal(String endingPrincipal) {
        this.endingPrincipal = endingPrincipal;
    }

}
