package com.jorypestorious.jsplabs.dto;

public class Lucky7Report {
    
    private int initialValue;
    private int maxValue = 0;
    private int maxTurn = 0;
    private int totalTurns = 0;
    
    public int getInitialValue() {
        return initialValue;
    }
    
    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
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
