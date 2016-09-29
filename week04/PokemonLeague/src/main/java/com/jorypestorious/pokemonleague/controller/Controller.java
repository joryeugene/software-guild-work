package com.jorypestorious.pokemonleague.controller;

import com.jorypestorious.pokemonleague.dao.DAO;
import com.jorypestorious.pokemonleague.ui.ConsoleIO;
import com.jorypestorious.pokemonleague.ui.UI;

public class Controller {
    
    private final UI ui;
    private final DAO dao;
    private final ConsoleIO io;
    
    public Controller(DAO dao) {
        this.dao = dao;
        this.io = new ConsoleIO();
        this.ui = new UI();
    }
    
    public void run() throws InterruptedException {
        
        String menuPrompt = "\n          POKEMON LEAGUE          \n" +
                            "==================================\n" +
                            "1. List All Teams\n" +
                            "2. List All Teams and Players\n" +
                            "3. List All Players on a Team\n" +
                            "4. Add a Team\n" +
                            "5. Add a Player\n" +
                            "6. Remove a Player\n" +
                            "7. Change a Player's Team\n" +
                            "8. Exit\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            
            int selection = io.promptInt(menuPrompt, 1, 8);
            
            switch(selection) {
                case 1:
                    ui.displayTeams(dao.getTeamRoster());
                    break;
                case 2:
                    ui.displayTeamsAndPlayers(dao.getTeamRoster());
                    break;
                case 3:
                    listPlayersOnTeam();
                    break;
                case 4:
                    addTeam();
                    break;
                case 5:
                    addPlayer();
                    break;
                case 6:
                    removePlayer();
                    break;
                case 7:
                    changeTeam();
                    break;
                case 8:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
        io.display("Good Bye!");
    }
    
    private void listPlayersOnTeam() {
        String team = io.promptString("> Team Name: ");
        
        if (dao.getTeam(team) != null) {
            ui.displayPlayers(dao.getTeam(team));
        } else {
            io.display("! Team Does Not Exist");
        }
    }
    
    private void addTeam() {
        String team = io.promptString("> Team Name: ");
        
        if (dao.createTeam(team)) {
            io.display("* Successfully added " + team);
        } else {
            io.display("! Team Already Exists");
        }
    }
    
    private void addPlayer() {
        String team = io.promptString("> Team Name: ");
        
        if (dao.getTeam(team) != null) {
            String player = io.promptString("> Player Name: ");
            
            if (dao.createPlayer(team, player)) {
                io.display("* Successfully added " + player + " to " + team);
            } else {
                io.display("! Player Already on Team");
            }
        } else {
            io.display("! Team Does Not Exist");
        }
    }
    
    private void removePlayer() {
        String team = io.promptString("> Team Name: ");
        
        if (dao.getTeam(team) != null) {
            String player = io.promptString("> Player Name: ");
            
            if (dao.deletePlayer(team, player)) {
                io.display("* Successfully removed " + player + " from " + team);
            } else {
                io.display("! Player Not Found");
            }
        } else {
            io.display("! Team Does Not Exist");
        }
        
    }
    
    private void changeTeam() {
        String oldTeam = io.promptString("> Current Team Name: ");
        
        if (dao.getTeam(oldTeam) != null) {
            String newTeam = io.promptString("> Team to Move to: ");
            
            if (dao.getTeam(newTeam) != null) {
                String player = io.promptString("> Player Name: ");
                
                if (dao.changeTeam(oldTeam, newTeam, player)) {
                    io.display("* Successfully moved " + player + " from " + oldTeam + " to " + newTeam);
                } else {
                    io.display("! Improper Move");
                }
            } else {
                io.display("! Team Does Not Exist");
            }
        } else {
            io.display("! Team Does Not Exist");
        }
    }

}
