/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;


/**
 *
 * @author User
 */
public class Player {
    String playerName;
    int playerID;
    Team team;
    
    public Player(String name,Team team){
        this.playerName = name;
        this.team = team;
    }
    
    public String getPlayerName(){
        return playerName;
    }
}
