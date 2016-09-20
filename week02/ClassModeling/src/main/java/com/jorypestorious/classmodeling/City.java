package com.jorypestorious.classmodeling;

public class City {
    
    private int population;
    private final String name;
    
    City (String name, int population) {
        this.name = name;
        this.population = population;
    }
    
    public void incrementPopulation(int num) {
        this.population += num;
    }
    
    public void decrementPopulation(int num) {
        this.population -= num;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

}
