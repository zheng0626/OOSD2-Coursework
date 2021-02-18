/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package year2coursework;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ScoreSheet {
    Team home_team;
    Team away_team;
    Player home_player;
    Player away_player;
    ArrayList<Set> sets = new ArrayList<>();
    String finalScore;
    int homeScore;
    int awayScore;
    
    public ScoreSheet(){
        home_team = null;
        away_team = null;
        for(int i = 0;i < 5;i++){
            sets.add(new Set());
        }
        
    }
    
    public void setHomeTeam(Team team){
        this.home_team = team;
    }
    
    public void setAwayTeam(Team team){
        this.away_team = team;
    }
    
    public void setHomePlayer(Player player){
        this.home_player = player;
    }
    
    public void setAwayPlayer(Player player){
        this.away_player = player;
    }    
    
    public void setSet(int index,Set set){  
        sets.set(index,set);
    }
    
    public void setScore(int home_score,int away_score){
        this.homeScore = home_score;
        this.awayScore = away_score;
        String finalScore = String.valueOf(homeScore) + ":" + String.valueOf(awayScore);
    }   
    
}
