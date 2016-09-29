package com.jorypestorious.pokemonleague.dao;

import com.jorypestorious.pokemonleague.dao.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository implements DAO {
    
    private final DataAccess dao;
    private final String filename;
    private final Map<String, List<String>> league;
    
    public Repository(String filename) {
        dao = new DataAccess();
        this.filename = filename;
        league = dao.fileToHashMap(filename);
    }

    @Override
    public Map getTeamRoster() {
        return new HashMap<>(league);
    }

    @Override
    public List getTeam(String teamName) {
        return league.get(teamName);
    }

    @Override
    public boolean createTeam(String teamName) {
        if (league.containsKey(teamName)) {
            return false;
        } else {
            league.put(teamName, new ArrayList<>());
            save();
            return true;
        }
    }

    @Override
    public boolean createPlayer(String teamName, String playerName) {
        if (league.get(teamName).contains(playerName)) {
            return false;
        } else {
            league.get(teamName).add(playerName);
            save();
            return true;
        }
    }

    @Override
    public boolean deletePlayer(String teamName, String playerName) {
        if (!league.get(teamName).contains(playerName)) {
            return false;
        } else {
            league.get(teamName).remove(playerName);
            save();
            return true;
        }
    }
    
    @Override
    public boolean changeTeam(String oldTeam, String newTeam, String playerName) {
        if (league.get(oldTeam).contains(playerName) && !league.get(newTeam).contains(playerName)) {
            league.get(newTeam).add(playerName);
            league.get(oldTeam).remove(playerName);
            save();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save() {
        dao.saveToFile(league, filename);
    }

}
