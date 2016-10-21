package com.swcguild.jspsitelab.dto;

public class UnitConversion {
    
    private final double value;
    private final String startingUnit;
    private final String endingUnit;
    private final double result;

    public UnitConversion(double value, String startingUnit, String endingUnit, double result) {
        this.value = value;
        this.startingUnit = startingUnit.toUpperCase().charAt(0) + startingUnit.substring(1);
        this.endingUnit = endingUnit.toUpperCase().charAt(0) + endingUnit.substring(1);
        this.result = result;
    }

    public double getValue() {
        return value;
    }

    public String getStartingUnit() {
        return startingUnit;
    }

    public String getEndingUnit() {
        return endingUnit;
    }

    public double getResult() {
        return result;
    }
    
}
