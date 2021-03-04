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
public class ScoreSheet {
    ArrayList<Set> sets = new ArrayList<>();
    private String homePlayer1;
    private String homePlayer2;
    private String awayPlayer1;
    private String awayPlayer2;
    String finalScore;
    int homeScore;
    int awayScore;
    
    public ScoreSheet(){
        for(int i = 0;i < 5;i++){
            sets.add(new Set());
        }
    }

    public void setSet(ArrayList<Set> set){  
        this.sets = set;
    }
    
    public void setScore(int home_score,int away_score){
        this.homeScore = home_score;
        this.awayScore = away_score;
        String finalScore = String.valueOf(homeScore) + ":" + String.valueOf(awayScore);
    }   
    
    public void setHomePlayer(String player1,String player2){
        this.homePlayer1 = player1;
        this.homePlayer2 = player2;
    }
    
    public void setAwayPlayer(String player1,String player2){
        this.awayPlayer1 = player1;
        this.awayPlayer2 = player2;
    }
    
    public ArrayList<Set> getSet(){
        return sets;
    }
    
}
