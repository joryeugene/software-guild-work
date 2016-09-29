package com.jorypestorious.pokemonleague.dao;

import java.util.List;
import java.util.Map;

public interface DAO {
    
    Map getTeamRoster();
    
    List getTeam(String teamName);
    
    boolean createTeam(String teamName);
    
    boolean createPlayer(String teamName, String playerName);
    
    boolean deletePlayer(String teamName, String playerName);
    
    boolean changeTeam(String oldTeam, String newTeam, String playerName);
    
    void save();

}
