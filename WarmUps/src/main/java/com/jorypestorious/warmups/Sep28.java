package com.jorypestorious.warmups;

import java.util.HashMap;

public class Sep28 {
    
    //Write code to declare and initialize a HashMap of state names to HashMaps of city names to populations.
    //Then write a line of code to set the population for some city and the code to retrieve that population.
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> statesAndCities = new HashMap<>();
        statesAndCities.put("Minnesota", new HashMap<>());
        statesAndCities.get("Minnesota").put("St. Bonifacius", 1111);
        statesAndCities.get("Minnesota").get("St.Bonifacius");
    }
    
    
}
