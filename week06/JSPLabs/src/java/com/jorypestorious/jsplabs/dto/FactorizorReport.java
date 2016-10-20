package com.jorypestorious.jsplabs.dto;

import java.util.ArrayList;
import java.util.List;

public class FactorizorReport {
    
    private int num;
    private List<Integer> factors;
    private boolean prime = false;
    private boolean perfect = false;
    
    public FactorizorReport() {
        factors = new ArrayList<>();
    }
    
    public void addFactor(int factor) {
        factors.add(factor);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
