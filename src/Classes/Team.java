/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Team {
    String teamName;
    int num_player = 0;
    int matchesPlayed;
    int matchesWon;
    int setsWon;
    ArrayList<Player> players = new ArrayList<Player>();
    
    public Team(String teamName){
        this.teamName = teamName;
        this.num_player++;
    }

    public String getTeamName(){
        return teamName;
    }
    
    public ArrayList<Player> getPlayer(){
        return players;
    }
    
    public void addPlayer(Player player){
        players.add(player);
        this.num_player++;
    }
    
    public int getNumPlayer(){
        return num_player;
    }
    //reset all the team match history
    public void reset(){
        matchesPlayed = 0;
        matchesWon = 0;
        setsWon = 0;
    }
    @Override
    public String toString(){
        return "TEAM NAME : " + this.teamName +"\nNum Player : " + this.num_player;
    }
    
}
