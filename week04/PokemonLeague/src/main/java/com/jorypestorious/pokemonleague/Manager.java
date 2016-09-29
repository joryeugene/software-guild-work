package com.jorypestorious.pokemonleague;

import com.jorypestorious.pokemonleague.controller.Controller;
import com.jorypestorious.pokemonleague.dao.Repository;

public class Manager {
    
    public static void main(String[] args) throws InterruptedException {
        new Controller(new Repository("league.txt")).run();
    }

}
