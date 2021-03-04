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
public class Match {
    private String homeTeam;
    private String awayTeam;
    private ScoreSheet scoreSheet;
    
    public Match(String home_team,String away_team){
        this.homeTeam = home_team;
        this.awayTeam = away_team;
        scoreSheet = new ScoreSheet();
    }
    public void setHomeTeam(String team){
        this.homeTeam = team;
    }
    
    public void setAwayTeam(String team){
        this.awayTeam = team;
    }
     
    public String getHomeTeam(){
        return homeTeam;
    }
    
    public String getAwayTeam(){
        return awayTeam;
    }
    
    public ScoreSheet getScoreSheet(){
        return scoreSheet;
    }
}
