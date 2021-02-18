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
public class Set {
    String home_player;
    String away_player;
    String game1;
    String game2;
    String game3;
    boolean result;
    
    public Set(){
        this.home_player = null;
        this.away_player = null;
        this.game1 = "0:0";
        this.game2 = "0:0";
        this.game3 = "0:0";
    }
    
    public Set(String home_player,String away_player,String game1,String game2,String game3){
        this.home_player = home_player;
        this.away_player = away_player;
        this.game1 = game1;
        this.game2 = game2;
        this.game3 = game3;
    }
    
    public String getHomePlayer(){
        return home_player;
    }
    
    public String getAwayPlayer(){
        return away_player;
    }
    
    public String getGame1(){
        return game1;
    }
    
    public String getGame2(){
        return game2;
    }
    
    public String getGame3(){
        return game3;
    }
    
    public boolean getResult(){
        return result;
    }
    
    public void setHomePlayer(Player hPlayer){
        this.home_player = hPlayer.getPlayerName();
    }
    
    public void setAwayPlayer(Player aPlayer){
        this.away_player = aPlayer.getPlayerName();
    }
    
    public void setGame1(String game1){
        this.game1 = game1;
    }
    
    public void setGame2(String game2){
        this.game2 = game2;
    }
    
    public void setGame3(String game3){
        this.game3 = game3;
    }
}
