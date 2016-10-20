package com.swcguild.jspsitelab.dto;

import java.util.ArrayList;
import java.util.List;

public class FactorizorReport {
    
    private final int num;
    private List<Integer> factors;
    private boolean prime = false;
    private boolean perfect = false;
    
    public FactorizorReport(int num) {
        this.num = num;
        factors = new ArrayList<>();
    }
    
    public int getNumOfFactors() {
        return factors.size();
    }
    
    public void addFactor(int factor) {
        factors.add(factor);
    }

    public int getNum() {
        return num;
    }

    public List<Integer> getFactors() {
        return factors;
    }

    public void setFactors(List<Integer> factors) {
        this.factors = factors;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public boolean isPerfect() {
        return perfect;
    }

    public void setPerfect(boolean perfect) {
        this.perfect = perfect;
    }

}
