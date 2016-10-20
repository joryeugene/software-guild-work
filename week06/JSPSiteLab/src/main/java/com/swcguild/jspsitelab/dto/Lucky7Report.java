package com.swcguild.jspsitelab.dto;

public class Lucky7Report {
    
    private final int initialValue;
    private int maxValue = 0;
    private int maxTurn = 0;
    private int totalTurns = 0;
    
    public Lucky7Report(int initialValue) {
        this.initialValue = initialValue;
    }
    
    public int getInitialValue() {
        return initialValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxTurn() {
        return maxTurn;
    }

    public void setMaxTurn(int maxTurn) {
        this.maxTurn = maxTurn;
    }

    public int getTotalTurns() {
        return totalTurns;
    }
    
    public void incrementNumOfTurns() {
        totalTurns++;
    }

}
